/**
 * 适配器模式（Adapter Pattern）是一种结构型设计模式，它允许将一个类的接口转换成另一个客户端所期望的接口。
 * 这种模式通常用于让现有的类与其他类协同工作而不需要修改它们的源代码。以下是一个 Java 示例，演示如何实现适配器模式：
 * 假设我们有一个老的音乐播放器类 OldMediaPlayer，它有一种播放 MP3 音乐的方法，
 * 但我们现在需要将这个类与新的音乐播放器接口 MediaPlayer 协同工作。我们可以创建一个适配器来实现这个接口并连接这两个类。
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */
package com.evil.structural.adapter;