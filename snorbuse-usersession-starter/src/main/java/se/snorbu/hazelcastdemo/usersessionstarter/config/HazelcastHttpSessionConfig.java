package se.snorbu.hazelcastdemo.usersessionstarter.config;


import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapAttributeConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.HazelcastSessionRepository;
import org.springframework.session.hazelcast.PrincipalNameExtractor;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

@EnableHazelcastHttpSession
@Configuration
public class HazelcastHttpSessionConfig {


    /**
     * Create a new {@code HazelcastInstance} object as a bean.
     * <p>
     * As a simple side-step to possible networking issues, turn off multicast
     * in favour of TCP connection to the local host.
     *
     * @return A new Hazelcast instance
     */
    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();

        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        joinConfig.getMulticastConfig().setEnabled(true);

        MapIndexConfig mapIndexConfig = new MapIndexConfig(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false);

        MapAttributeConfig attributeConfig = new MapAttributeConfig()
                .setName(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
                .setExtractor(PrincipalNameExtractor.class.getName());

        config.getMapConfig(HazelcastSessionRepository.DEFAULT_SESSION_MAP_NAME)
                .addMapAttributeConfig(attributeConfig)
                .addMapIndexConfig(mapIndexConfig);

        return Hazelcast.newHazelcastInstance(config);
    }
}


