package gs.sbhh.springbatchhttptohttp.batch.config;

import gs.sbhh.springbatchhttptohttp.batch.model.IncomingShip;
import gs.sbhh.springbatchhttptohttp.batch.model.OutgoingShip;
import gs.sbhh.springbatchhttptohttp.batch.processing.ShipHTTPReader;
import gs.sbhh.springbatchhttptohttp.batch.processing.ShipProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableBatchProcessing
public class ShipBatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    private RestTemplate restTemplate = new RestTemplate();

    @Bean
    public ShipHTTPReader reader() {
        return new ShipHTTPReader("", restTemplate);
    }

    @Bean
    public ShipProcessor processor() {
        return new ShipProcessor();
    }

    @Bean
    public Job transferShipJob(Step transferStep) {
        return jobBuilderFactory.get("transferShipJob")
                .incrementer(new RunIdIncrementer())
                .flow(transferStep)
                .end()
                .build();
    }

    @Bean
    public Step transferShip() {
        return stepBuilderFactory.get("transferShip")
                .<IncomingShip, OutgoingShip> chunk(10)
                .reader(reader())
                .processor(processor())
                .build();
    }
}
