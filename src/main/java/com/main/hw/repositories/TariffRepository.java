package com.main.hw.repositories;

import com.main.hw.models.CallPrices;
import com.main.hw.models.Tariff;
import com.main.hw.models.Parameters;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class TariffRepository
{
    private List<Tariff> tariffs;

    public List<Tariff> findAll()
    {
        return tariffs;
    }

    @PostConstruct
    public void init()
    {
        tariffs = new ArrayList<>();

        var random = new Random(1);

        for(int i = 0; i < 10; i++)
        {
            tariffs.add(new Tariff("Tariff" + String.valueOf(i),
                    "Operator" + String.valueOf(10 - i),
                    (float)random.nextInt(100, 1000),
                    new CallPrices((float)random.nextInt(100,1000),
                                    (float)random.nextInt(100,1000),
                                    (float)random.nextInt(100,1000)),
                    (float)random.nextInt(100, 1000),
                    new Parameters("8 800 555 35 55",
                            (float)random.nextInt(100,1000),
                            (float)random.nextInt(100,1000))
            ));
        }
    }
}
