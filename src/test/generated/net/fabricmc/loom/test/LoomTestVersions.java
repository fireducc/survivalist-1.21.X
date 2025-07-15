/*
 * This file is part of fabric-loom, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2025 FabricMC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.fabricmc.loom.test;

/**
 * Auto generated class, do not edit.
 */
public record LoomTestVersions(String group, String module, String version) {
	public static final LoomTestVersions FABRIC_LOADER = new LoomTestVersions("net.fabricmc", "fabric-loader", "0.16.9");
	public static final LoomTestVersions GRADLE_NIGHTLY = new LoomTestVersions("org.gradle", "dummy", "8.14-20250208001853+0000");
	public static final LoomTestVersions JAVA_DEBUG = new LoomTestVersions("com.microsoft.java", "com.microsoft.java.debug.core", "0.52.0");
	public static final LoomTestVersions JAVALIN = new LoomTestVersions("io.javalin", "javalin", "6.3.0");
	public static final LoomTestVersions JUNIT_JUPITER_ENGINE = new LoomTestVersions("org.junit.jupiter", "junit-jupiter-engine", "5.11.3");
	public static final LoomTestVersions MIXIN = new LoomTestVersions("net.fabricmc", "sponge-mixin", "0.15.3+mixin.0.8.7");
	public static final LoomTestVersions MOCKITO = new LoomTestVersions("org.mockito", "mockito-core", "5.14.2");
	public static final LoomTestVersions SPOCK = new LoomTestVersions("org.spockframework", "spock-core", "2.3-groovy-3.0");

	public String mavenNotation() {
		return "%s:%s:%s".formatted(group, module, version);
	}
}
