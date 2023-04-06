package com.tool.kit.utils;

import com.tool.kit.exception.SystemIOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.*;

import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.Checksum;


@Slf4j
public class FileUtils {

    private FileUtils() {

    }

    public static List<File> listFiles(String filePath) {
        try {
            return Files.walk(Paths.get(filePath))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return new ArrayList<>();
    }


    public static String byteCountToDisplaySize(final BigInteger size) {
        return org.apache.commons.io.FileUtils.byteCountToDisplaySize(size);
    }

    public static String byteCountToDisplaySize(final long size) {
        return org.apache.commons.io.FileUtils.byteCountToDisplaySize(size);
    }

    public static Checksum checksum(final File file, final Checksum checksum) {
        try {
            return org.apache.commons.io.FileUtils.checksum(file, checksum);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static long checksumCRC32(final File file) {
        try {
            return org.apache.commons.io.FileUtils.checksumCRC32(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void cleanDirectory(final File directory) {
        try {
            org.apache.commons.io.FileUtils.cleanDirectory(directory);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static boolean contentEquals(final File file1, final File file2) {
        try {
            return org.apache.commons.io.FileUtils.contentEquals(file1, file2);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static boolean contentEqualsIgnoreEOL(final File file1, final File file2, final String charsetName) {
        try {
            return org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(file1, file2, charsetName);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static File[] convertFileCollectionToFileArray(final Collection<File> files) {
        return org.apache.commons.io.FileUtils.convertFileCollectionToFileArray(files);
    }

    public static void copyDirectory(final File srcDir, final File destDir) {
        try {
            org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyDirectory(final File srcDir, final File destDir, final boolean preserveFileDate) {
        try {
            org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir, preserveFileDate);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyDirectory(final File srcDir, final File destDir, final FileFilter filter) {
        try {
            org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir, filter);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyDirectoryToDirectory(final File sourceDir, final File destinationDir) {
        try {
            org.apache.commons.io.FileUtils.copyDirectoryToDirectory(sourceDir, destinationDir);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyFile(final File srcFile, final File destFile) {
        try {
            org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyFile(final File srcFile, final File destFile, final boolean preserveFileDate) {
        try {
            org.apache.commons.io.FileUtils.copyFile(srcFile, destFile, preserveFileDate);
        } catch (
                IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyFile(final File srcFile, final File destFile, final CopyOption... copyOptions) {
        try {
            org.apache.commons.io.FileUtils.copyFile(srcFile, destFile, copyOptions);
        } catch (
                IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static long copyFile(final File input, final OutputStream output) {
        try {
            return org.apache.commons.io.FileUtils.copyFile(input, output);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyFileToDirectory(final File srcFile, final File destDir) {
        try {
            org.apache.commons.io.FileUtils.copyFileToDirectory(srcFile, destDir);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyFileToDirectory(final File sourceFile, final File destinationDir, final boolean preserveFileDate) {
        try {
            org.apache.commons.io.FileUtils.copyFileToDirectory(sourceFile, destinationDir, preserveFileDate);
        } catch (
                IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyInputStreamToFile(final InputStream source, final File destination) {
        try {
            org.apache.commons.io.FileUtils.copyInputStreamToFile(source, destination);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyToDirectory(final File sourceFile, final File destinationDir) {
        try {
            org.apache.commons.io.FileUtils.copyToDirectory(sourceFile, destinationDir);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyToDirectory(final Iterable<File> sourceIterable, final File destinationDir) {
        try {
            org.apache.commons.io.FileUtils.copyToDirectory(sourceIterable, destinationDir);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyToFile(final InputStream inputStream, final File file) {
        try {
            org.apache.commons.io.FileUtils.copyToFile(inputStream, file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void copyURLToFile(final URL source, final File destination) {
        try {
            org.apache.commons.io.FileUtils.copyURLToFile(source, destination);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static File createParentDirectories(final File file) {
        try {
            return org.apache.commons.io.FileUtils.createParentDirectories(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static File delete(final File file) {
        try {
            return org.apache.commons.io.FileUtils.delete(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void deleteDirectory(final File directory) {
        try {
            org.apache.commons.io.FileUtils.deleteDirectory(directory);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static boolean deleteQuietly(final File file) {
        return org.apache.commons.io.FileUtils.deleteQuietly(file);
    }

    public static boolean directoryContains(final File directory, final File child) {
        try {
            return org.apache.commons.io.FileUtils.directoryContains(directory, child);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void forceDelete(final File file) {
        try {
            org.apache.commons.io.FileUtils.forceDelete(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void forceDeleteOnExit(final File file) {
        try {
            org.apache.commons.io.FileUtils.forceDeleteOnExit(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void forceMkdir(final File directory) {
        try {
            org.apache.commons.io.FileUtils.forceMkdir(directory);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void forceMkdirParent(final File file) {
        try {
            org.apache.commons.io.FileUtils.forceMkdirParent(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static File getFile(final File directory, final String... names) {
        return org.apache.commons.io.FileUtils.getFile(directory, names);
    }

    public static File getFile(final String... names) {
        return org.apache.commons.io.FileUtils.getFile(names);
    }

    public static File getTempDirectory() {
        return org.apache.commons.io.FileUtils.getTempDirectory();
    }

    public static String getTempDirectoryPath() {
        return org.apache.commons.io.FileUtils.getTempDirectoryPath();
    }

    public static File getUserDirectory() {
        return org.apache.commons.io.FileUtils.getUserDirectory();
    }

    public static String getUserDirectoryPath() {
        return org.apache.commons.io.FileUtils.getUserDirectoryPath();
    }

    public static boolean isDirectory(final File file, final LinkOption... options) {
        return org.apache.commons.io.FileUtils.isDirectory(file, options);
    }

    public static boolean isEmptyDirectory(final File directory) {
        try {
            return org.apache.commons.io.FileUtils.isEmptyDirectory(directory);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static boolean isFileNewer(final File file, final ChronoLocalDate chronoLocalDate) {
        return org.apache.commons.io.FileUtils.isFileNewer(file, chronoLocalDate);
    }

    public static boolean isFileNewer(final File file, final ChronoLocalDate chronoLocalDate, final LocalTime localTime) {
        return org.apache.commons.io.FileUtils.isFileNewer(file, chronoLocalDate, localTime);
    }

    public static boolean isFileNewer(final File file, final ChronoLocalDateTime<?> chronoLocalDateTime) {
        return org.apache.commons.io.FileUtils.isFileNewer(file, chronoLocalDateTime);
    }

    public static boolean isFileNewer(final File file, final ChronoLocalDateTime<?> chronoLocalDateTime, final ZoneId zoneId) {
        return org.apache.commons.io.FileUtils.isFileNewer(file, chronoLocalDateTime, zoneId);
    }

    public static boolean isFileNewer(final File file, final ChronoZonedDateTime<?> chronoZonedDateTime) {
        return org.apache.commons.io.FileUtils.isFileNewer(file, chronoZonedDateTime);
    }

    public static boolean isFileNewer(final File file, final Date date) {
        return org.apache.commons.io.FileUtils.isFileNewer(file, date);
    }

    public static boolean isFileNewer(final File file, final File reference) {
        return org.apache.commons.io.FileUtils.isFileNewer(file, reference);
    }

    public static boolean isFileNewer(final File file, final Instant instant) {
        return org.apache.commons.io.FileUtils.isFileNewer(file, instant);
    }

    public static boolean isFileNewer(final File file, final long timeMillis) {
        return org.apache.commons.io.FileUtils.isFileNewer(file, timeMillis);
    }

    public static boolean isFileOlder(final File file, final ChronoLocalDate chronoLocalDate) {
        return org.apache.commons.io.FileUtils.isFileOlder(file, chronoLocalDate);
    }

    public static boolean isFileOlder(final File file, final ChronoLocalDate chronoLocalDate, final LocalTime localTime) {
        return org.apache.commons.io.FileUtils.isFileOlder(file, chronoLocalDate, localTime);
    }

    public static boolean isFileOlder(final File file, final ChronoLocalDateTime<?> chronoLocalDateTime) {
        return org.apache.commons.io.FileUtils.isFileOlder(file, chronoLocalDateTime);
    }

    public static boolean isFileOlder(final File file, final ChronoLocalDateTime<?> chronoLocalDateTime, final ZoneId zoneId) {
        return org.apache.commons.io.FileUtils.isFileOlder(file, chronoLocalDateTime, zoneId);
    }

    public static boolean isFileOlder(final File file, final ChronoZonedDateTime<?> chronoZonedDateTime) {
        return org.apache.commons.io.FileUtils.isFileOlder(file, chronoZonedDateTime);
    }

    public static boolean isFileOlder(final File file, final Date date) {
        return org.apache.commons.io.FileUtils.isFileOlder(file, date);
    }

    public static boolean isFileOlder(final File file, final File reference) {
        return org.apache.commons.io.FileUtils.isFileOlder(file, reference);
    }

    public static boolean isFileOlder(final File file, final Instant instant) {
        return org.apache.commons.io.FileUtils.isFileOlder(file, instant);
    }

    public static boolean isFileOlder(final File file, final long timeMillis) {
        return org.apache.commons.io.FileUtils.isFileOlder(file, timeMillis);
    }

    public static boolean isRegularFile(final File file, final LinkOption... options) {
        return org.apache.commons.io.FileUtils.isRegularFile(file, options);
    }

    public static boolean isSymlink(final File file) {
        return org.apache.commons.io.FileUtils.isSymlink(file);
    }

    public static long lastModified(final File file) {
        try {
            return org.apache.commons.io.FileUtils.lastModified(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static long lastModifiedUnchecked(final File file) {
        return org.apache.commons.io.FileUtils.lastModifiedUnchecked(file);
    }

    public static LineIterator lineIterator(final File file) {
        try {
            return org.apache.commons.io.FileUtils.lineIterator(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static LineIterator lineIterator(final File file, final String charsetName) {
        try {
            return org.apache.commons.io.FileUtils.lineIterator(file, charsetName);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static Collection<File> listFiles(final File directory, final String[] extensions, final boolean recursive) {
        return org.apache.commons.io.FileUtils.listFiles(directory, extensions, recursive);
    }

    public static void moveDirectory(final File srcDir, final File destDir) {
        try {
            org.apache.commons.io.FileUtils.moveDirectory(srcDir, destDir);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void moveDirectoryToDirectory(final File src, final File destDir, final boolean createDestDir) {
        try {
            org.apache.commons.io.FileUtils.moveDirectoryToDirectory(src, destDir, createDestDir);
        } catch (
                IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void moveFile(final File srcFile, final File destFile) {
        try {
            org.apache.commons.io.FileUtils.moveFile(srcFile, destFile);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void moveFile(final File srcFile, final File destFile, final CopyOption... copyOptions) {
        try {
            org.apache.commons.io.FileUtils.moveFile(srcFile, destFile, copyOptions);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }

    }

    public static void moveFileToDirectory(final File srcFile, final File destDir, final boolean createDestDir) {
        try {
            org.apache.commons.io.FileUtils.moveFileToDirectory(srcFile, destDir, createDestDir);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void moveToDirectory(final File src, final File destDir, final boolean createDestDir) {
        try {
            org.apache.commons.io.FileUtils.moveToDirectory(src, destDir, createDestDir);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static FileInputStream openInputStream(final File file) {
        try {
            return org.apache.commons.io.FileUtils.openInputStream(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static FileOutputStream openOutputStream(final File file) {
        try {
            return org.apache.commons.io.FileUtils.openOutputStream(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static FileOutputStream openOutputStream(final File file, final boolean append) {
        try {
            return org.apache.commons.io.FileUtils.openOutputStream(file, append);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static byte[] readFileToByteArray(final File file) {
        try {
            return org.apache.commons.io.FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static String readFileToString(final File file) {
        try {
            return org.apache.commons.io.FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static String readFileToString(final File file, final Charset charsetName) {
        try {
            return org.apache.commons.io.FileUtils.readFileToString(file, charsetName);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static String readFileToString(final File file, final String charsetName) {
        try {
            return org.apache.commons.io.FileUtils.readFileToString(file, charsetName);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static List<String> readLines(final File file) {
        try {
            return org.apache.commons.io.FileUtils.readLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static List<String> readLines(final File file, final Charset charset) {
        try {
            return org.apache.commons.io.FileUtils.readLines(file, charset);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static List<String> readLines(final File file, final String charsetName) {
        try {
            return org.apache.commons.io.FileUtils.readLines(file, charsetName);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static long sizeOf(final File file) {
        return org.apache.commons.io.FileUtils.sizeOf(file);
    }

    public static BigInteger sizeOfAsBigInteger(final File file) {
        return org.apache.commons.io.FileUtils.sizeOfAsBigInteger(file);
    }

    public static long sizeOfDirectory(final File directory) {
        return org.apache.commons.io.FileUtils.sizeOfDirectory(directory);
    }

    public static BigInteger sizeOfDirectoryAsBigInteger(final File directory) {
        return org.apache.commons.io.FileUtils.sizeOfDirectoryAsBigInteger(directory);
    }

    public static Stream<File> streamFiles(final File directory, final boolean recursive, final String... extensions) {
        try {
            return org.apache.commons.io.FileUtils.streamFiles(directory, recursive, extensions);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static File toFile(final URL url) {
        return org.apache.commons.io.FileUtils.toFile(url);
    }

    public static File[] toFiles(final URL... urls) {
        return org.apache.commons.io.FileUtils.toFiles(urls);
    }

    public static void touch(final File file) {
        try {
            org.apache.commons.io.FileUtils.touch(file);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static URL[] toURLs(final File... files) {
        try {
            return org.apache.commons.io.FileUtils.toURLs(files);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static boolean waitFor(final File file, final int seconds) {
        return org.apache.commons.io.FileUtils.waitFor(file, seconds);
    }

    public static void write(final File file, final CharSequence data) {
        try {
            org.apache.commons.io.FileUtils.write(file, data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void write(final File file, final CharSequence data, final boolean append) {
        try {
            org.apache.commons.io.FileUtils.write(file, data, StandardCharsets.UTF_8, append);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void write(final File file, final CharSequence data, final Charset charset) {
        try {
            org.apache.commons.io.FileUtils.write(file, data, charset);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void write(final File file, final CharSequence data, final String charsetName) {
        try {
            org.apache.commons.io.FileUtils.write(file, data, charsetName);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void writeByteArrayToFile(final File file, final byte[] data) {
        try {
            org.apache.commons.io.FileUtils.writeByteArrayToFile(file, data);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void writeByteArrayToFile(final File file, final byte[] data, final boolean append) {
        try {
            org.apache.commons.io.FileUtils.writeByteArrayToFile(file, data, append);
        } catch (
                IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void writeLines(final File file, final Collection<?> lines) {
        try {
            org.apache.commons.io.FileUtils.writeLines(file, lines);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void writeLines(final File file, final Collection<?> lines, final boolean append) {
        try {
            org.apache.commons.io.FileUtils.writeLines(file, lines, append);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void writeLines(final File file, final Collection<?> lines, final String lineEnding) {
        try {
            org.apache.commons.io.FileUtils.writeLines(file, lines, lineEnding);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void writeLines(final File file, final String charsetName, final Collection<?> lines) {
        try {
            org.apache.commons.io.FileUtils.writeLines(file, charsetName, lines);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void writeStringToFile(final File file, final String data) {
        try {
            org.apache.commons.io.FileUtils.writeStringToFile(file, data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void writeStringToFile(final File file, final String data, final boolean append) {
        try {
            org.apache.commons.io.FileUtils.writeStringToFile(file, data, StandardCharsets.UTF_8, append);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }

    public static void writeStringToFile(final File file, final String data, final Charset charset) {
        try {
            org.apache.commons.io.FileUtils.writeStringToFile(file, data, charset);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }

    }

    public static void writeStringToFile(final File file, final String data, final String charsetName) {
        try {
            org.apache.commons.io.FileUtils.writeStringToFile(file, data, charsetName);
        } catch (IOException e) {
            throw new SystemIOException("unable to read file");
        }
    }


}
