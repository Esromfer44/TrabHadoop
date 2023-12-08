package org.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

 
public class TypeFileSharingsMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable contagem = new IntWritable(1);
    private final Text tipoPalavra = new Text();

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        StringTokenizer tokenizer = new StringTokenizer(value.toString());

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (token.contains("Type")) {
            
                if (tokenizer.hasMoreTokens()) {
                    tipoPalavra.set(tokenizer.nextToken().toLowerCase().replaceAll("[^a-zA-Z]", ""));

                    if (tipoPalavra != null) {
                        context.write(tipoPalavra, contagem);
                    }
                }
            }
        }
    }
}
