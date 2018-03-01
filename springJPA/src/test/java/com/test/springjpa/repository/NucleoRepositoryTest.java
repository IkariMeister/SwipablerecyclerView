package com.test.springjpa.repository;

import com.test.springjpa.config.AppConfig;
import com.test.springjpa.entities.db.NucleoDB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertTrue;

/**
 * Created by jcgarcia on 29/05/2017.
 */

@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {AppConfig.class})
@ActiveProfiles("local")
//@RunWith(SpringJUnit4ClassRunner.class)
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
//        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class NucleoRepositoryTest {
    @Autowired
    private NucleoRepository repository;

    @Test
    public void save() {
        NucleoDB nucleoDB = new NucleoDB();
        nucleoDB.setCdgoNucleo(3);
        nucleoDB.setCentroCic("CIC");
        nucleoDB.setMailCic("cictest@renfe.es");

        repository.save(nucleoDB);

        boolean match = false;
        for (NucleoDB n : repository.findAll()) {
            match = nucleoDB.equals(n);
            if (match) break;
        }
        assertTrue(match);
    }
}