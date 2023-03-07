package com.saranganrajan.apps.coredomainpublisher;

import com.azure.spring.messaging.checkpoint.Checkpointer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import static com.azure.spring.messaging.AzureHeaders.CHECKPOINTER;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
@Slf4j
@EnableFeignClients
@ComponentScan(basePackages = {"com.saranganrajan.apps.coredomainpublisher"})
public class CoreDomainPublisherApplication {


	//private static final Sinks.Many<Message<String>> many = Sinks.many().unicast().onBackpressureBuffer();

	public static void main(String[] args) {

		SpringApplication.run(CoreDomainPublisherApplication.class, args);
		ObjectMapper mapper = JsonMapper.builder()
				.findAndAddModules()
				.build();
	}

//	@Bean
//	public Supplier<Flux<Message<String>>> supply() {
//		return ()->many.asFlux()
//				.doOnNext(m->log.info("Manually sending message {}", m))
//				.doOnError(t->log.error("Error encountered", t));
//	}
//
//	@Bean
//	public Consumer<Message<String>> consume() {
//		return message->{
//			Checkpointer checkpointer = (Checkpointer) message.getHeaders().get(CHECKPOINTER);
//			log.info("New message received: '{}'", message.getPayload());
//			checkpointer.success()
//					.doOnSuccess(s->log.info("Message '{}' successfully checkpointed", message.getPayload()))
//					.doOnError(e->log.error("Error found", e))
//					.block();
//		};
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		log.info("Going to add message {} to Sinks.Many.", "Hello Word");
//		many.emitNext(MessageBuilder.withPayload("Hello Word").build(), Sinks.EmitFailureHandler.FAIL_FAST);
//	}
}
