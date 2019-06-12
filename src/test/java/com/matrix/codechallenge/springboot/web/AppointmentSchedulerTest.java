package com.matrix.codechallenge.springboot.web;

import com.matrix.codechallenge.springboot.web.DAO.User;
import com.matrix.codechallenge.springboot.web.repository.AppointmentRespository;
import com.matrix.codechallenge.springboot.web.repository.UserRepository;
import com.matrix.codechallenge.springboot.web.service.AppointmentServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentSchedulerTest {

    @Autowired
    private AppointmentRespository appointmentRespository;

    @Autowired
    private AppointmentServices appointmentServices;
    @Test
    public void findAppointByConfirmationNumber(){
        String confirmation_number="201";
        User user=appointmentServices.getAppointmentDetails(confirmation_number);

        assertThat(user.getFirstName()).isEqualTo("siddhu");

    }
}
