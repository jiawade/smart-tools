package io.github.jiawade.tool.utils;


import com.google.common.collect.Sets;
import io.cucumber.junit.CucumberOptions;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FeatureTagUtil {

    public static Map<String, Map<String, List<String>>> getAllExecutionScenarios(Class<?> clazz) {
        CucumberOptions tagString = clazz.getDeclaredAnnotation(CucumberOptions.class);
        List<String> featureFilesPath = Arrays.stream(tagString.features()).collect(Collectors.toList());
        List<File> featureFiles = featureFilesPath.stream()
                .map(FileUtils::listFiles)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()).stream()
                .filter(i -> i.toString().endsWith(".feature")).collect(Collectors.toList());
        return filterFeatureByTag(tagString.tags(), getAllFeatures(featureFiles));

    }

    public static List<Feature> getAllFeatures(List<File> featureFiles) {
        return featureFiles.stream().map(i -> featureParser(FileUtils.readLines(i.getAbsoluteFile()), i.getName())).collect(Collectors.toList());
    }

    public static Map<String, Map<String, List<String>>> filterFeatureByTag(String tags, List<Feature> features) {
        Map<String, Map<String, List<String>>> featureAndScenarios = features.stream().collect(Collectors.toMap(k -> k.getFeatureFileName(), k -> k.getScenarioNameAndTag()));
        List<Map<String, List<String>>> allScenarios = features.stream().map(Feature::getScenarioNameAndTag).collect(Collectors.toList());
        List<String> all = getAllTags(tags);
        List<String> not = getNotTags(tags);
        Set<String> andExe = Sets.difference(Sets.newHashSet(all), Sets.newHashSet(not));
        return featureAndScenarios.entrySet().stream().collect(Collectors.toMap(b -> b.getKey(), b -> b.getValue().entrySet().stream()
                .filter(j -> containsAny(j.getValue(), andExe))
                .filter(l -> !containsAny(l.getValue(), not))
                .filter(n -> n.getValue().containsAll(andExe))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
        )).entrySet().stream().filter(m -> m.getValue().size() > 0).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        /*List<Map<String, List<String>>> filteredFeatures = allScenarios.stream()
                .map(i -> i.entrySet().stream()
                        .filter(j -> containsAny(j.getValue(), andExe))
                        .filter(l -> !containsAny(l.getValue(), not))
                        .filter(n -> n.getValue().containsAll(andExe))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ).filter(k -> !k.isEmpty()).collect(Collectors.toList());
        return filteredFeatures;*/
    }

    private static boolean containsAny(Collection<String> source, Collection<String> not) {
        return source.stream().anyMatch(not::contains);
    }

    private static List<String> getAndTags(String tags) {
        String inclusionRegex = " *and +@[^ ]+";
        Pattern r = Pattern.compile(inclusionRegex);
        Matcher m = r.matcher(tags);
        List<String> AndTag = new ArrayList<>();
        while (m.find()) {
            AndTag.add(m.group().replaceAll(" +and +", ""));
        }
        return AndTag;
    }


    private static List<String> getAllTags(String tags) {
        String inclusionRegex = " *@[^ ]+";
        Pattern r = Pattern.compile(inclusionRegex);
        Matcher m = r.matcher(tags);
        List<String> allTag = new ArrayList<>();
        while (m.find()) {
            allTag.add(m.group().trim());
        }
        return allTag;
    }


    private static List<String> getNotTags(String tags) {
        String exclusionRegex = " *not +@[^ ]+";
        Pattern r = Pattern.compile(exclusionRegex);
        Matcher m = r.matcher(tags);
        List<String> notTag = new ArrayList<>();
        while (m.find()) {
            notTag.add(m.group().replaceAll(" *not +", ""));
        }
        return notTag;
    }

    private static Feature featureParser(List<String> content, String fileName) {
        String tagRegex = "([ ]*)(@)(.+)";
        String featureNameRegex = "([ ]*)(Feature[ ]*:[ ]*)(.*)";
        String scenarioNameRegex = "([ ]*)(Scenario.*:[ ]*)(.*)";

        List<String> text = content.stream().filter(i -> !"".equals(i)).filter(j -> !j.matches("[ ]+")).collect(Collectors.toList());
        Feature feature = new Feature();
        feature.setFeatureFileName(fileName);
        Map<String, List<String>> scenarioNameAndTag = new HashMap<>();
        for (String i : text) {
            String tag = getLast(text, i).trim();
            if (i.matches(featureNameRegex)) {
                Pattern r = Pattern.compile(featureNameRegex);
                Matcher m = r.matcher(i);
                while (m.find())
                    feature.setFeatureName(m.group(3));
                if (tag.contains("@")) {
                    feature.setFeatureTag(Arrays.asList(tag.split(" +")));
                }
            } else if (i.matches(scenarioNameRegex)) {
                Pattern r = Pattern.compile(scenarioNameRegex);
                Matcher m = r.matcher(i);
                String name = "";
                while (m.find())
                    name = m.group(3);
                List<String> tags = new ArrayList<>();
                if (feature.getFeatureTag() != null) {
                    tags.addAll(feature.getFeatureTag());
                }
                if (tag.matches(tagRegex)) {
                    tags.addAll(Arrays.asList(tag.split(" +")));
                    scenarioNameAndTag.put(name, tags);
                } else {
                    scenarioNameAndTag.put(name, tags);
                }
            }
        }
        feature.setScenarioNameAndTag(scenarioNameAndTag);
        return feature;
    }


    private static String getNext(List<String> myList, String uid) {
        int idx = myList.indexOf(uid);
        if (idx < 0 || idx + 1 == myList.size()) return "";
        return myList.get(idx + 1);
    }

    private static String getLast(List<String> myList, String uid) {
        int idx = myList.indexOf(uid);
        String tag = "";

        for (int i = 0; i < myList.size(); i++) {
            if (idx <= 0) return "";
            if (myList.get(idx - 1).matches("[ |\\s]+")) {
                continue;
            }
            tag = myList.get(idx - 1);
        }
        return tag;
    }

    public static class Feature {
        public String featureFileName;
        public String featureName;
        public List<String> featureTag;
        public Map<String, List<String>> scenarioNameAndTag = new HashMap<>();

        public Feature() {
        }

        public Feature(String featureFileName, String featureName, List<String> featureTag, Map<String, List<String>> scenarioNameAndTag) {
            this.featureFileName = featureFileName;
            this.featureName = featureName;
            this.featureTag = featureTag;
            this.scenarioNameAndTag = scenarioNameAndTag;
        }

        public String getFeatureFileName() {
            return featureFileName;
        }

        public void setFeatureFileName(String featureFileName) {
            this.featureFileName = featureFileName;
        }

        public String getFeatureName() {
            return featureName;
        }

        public void setFeatureName(String featureName) {
            this.featureName = featureName;
        }

        public List<String> getFeatureTag() {
            return featureTag;
        }

        public void setFeatureTag(List<String> featureTag) {
            this.featureTag = featureTag;
        }

        public Map<String, List<String>> getScenarioNameAndTag() {
            return scenarioNameAndTag;
        }

        public void setScenarioNameAndTag(Map<String, List<String>> scenarioTagAndName) {
            this.scenarioNameAndTag = scenarioTagAndName;
        }

        public int getScenariosNumber() {
            return this.scenarioNameAndTag.size();
        }

        @Override
        public String toString() {
            return "Feature{" +
                    "featureFileName='" + featureFileName + '\'' +
                    ", featureName='" + featureName + '\'' +
                    ", featureTag=" + featureTag +
                    ", scenarioNameAndTag=" + scenarioNameAndTag +
                    '}';
        }
    }

}
