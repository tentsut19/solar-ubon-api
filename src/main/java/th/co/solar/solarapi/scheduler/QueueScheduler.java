package th.co.solar.solarapi.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import th.co.solar.solarapi.service.ConsumerService;

import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
public class QueueScheduler {

    @Value("${queue.enable:false}")
    private boolean enable;

    @Autowired
    private ConsumerService consumerService;

    @Scheduled(cron = "${queue.interval-cron}")
    public void execute() throws IOException {
        if (enable) {
            consumerService.processQueue();
        }
    }
}
