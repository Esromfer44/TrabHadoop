package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class Main {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "Contagem de Hashtags");

        job.setJarByClass(Main.class);

        job.setMapperClass(TypeFileSharingsMapper.class);

        job.setReducerClass(FileSharingsReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        
        FileInputFormat.addInputPath(job, new Path("dev-gpt-bases"));

        FileOutputFormat.setOutputPath(job, new Path("saida"));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
