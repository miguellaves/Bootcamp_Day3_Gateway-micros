package com.nttdata.gateway;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@Configuration
public class configfiltro {

	@Bean
	@Order(-1)
	public GlobalFilter a() {
		return (exchange, chain) -> {
			log.info("first pre filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("third post filter");
			}));
//			Mono<Void> s = chain.filter(exchange);
//	        s.then(Mono.fromRunnable(() -> logger.info("first post filter")));
//	        return s;
		};
	}

	@Bean
	@Order(0)
	public GlobalFilter b() {
		return (exchange, chain) -> {
			log.info("second pre filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("second post filter");
			}));
		};
	}

	@Bean
	@Order(1)
	public GlobalFilter c() {
		return (exchange, chain) -> {
			log.info("third pre filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("one post filter");
			}));
		};
	}

}
