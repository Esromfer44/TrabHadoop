package org.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class FileSharingsReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private final IntWritable somaTotal = new IntWritable();

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int soma = 0;

        for (IntWritable val : values) {
            soma += val.get();
        }

        somaTotal.set(soma);
        if (key != null) {
            context.write(key, somaTotal);
        }
    }
}
