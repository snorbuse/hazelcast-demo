package se.snorbu.hazelcastdemo.config;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.snorbu.hazelcastdemo.domain.repository.UserdataRepository;
import se.snorbu.hazelcastdemo.impl.HazelcastUserdataRepository;
import se.snorbu.hazelcastdemo.sessionstarter.config.ApplicationHazelcastMap;
import se.snorbu.hazelcastdemo.usersessionstarter.config.UserawareHazelcastMap;

import javax.servlet.http.HttpSession;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserdataRepository userdataRepository(UserawareHazelcastMap<Class, Object> userawareMap) {
        return new HazelcastUserdataRepository(userawareMap);
    }

    @Bean
    public UserawareHazelcastMap<Class, Object> userawareMap(HttpSession httpSession, HazelcastInstance hazelcastInstance) {
        return new UserawareHazelcastMap<>(httpSession, hazelcastInstance);
    }

    @Bean
    public ApplicationHazelcastMap<String, Integer> hitsHazelcastMap(HazelcastInstance hazelcastInstance) {
        return new ApplicationHazelcastMap<>("hits", hazelcastInstance);
    }
}
