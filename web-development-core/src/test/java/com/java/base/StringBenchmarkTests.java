package com.java.base;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @Package com.java.base
 * @ClassName StringTests
 * @Description TODO
 * @Author Ryan
 * @Date 3/17/2023
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
@Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
public class StringBenchmarkTests {
    private final int numbers = 1_000_000;

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);

//        Options opt = new OptionsBuilder()
//                .include(StringTests.class.getSimpleName())
//                .build();
//
//        new Runner(opt).run();
    }

    @Benchmark
    public void fastStringConcat() {
        StringBuilder sb = new StringBuilder();
        sb.append("*");
    }

    @Benchmark
    public void slowStringConcat() {
        String s = "";
        s += "*";
    }
}
