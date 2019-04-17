package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class HobbyConverter implements Converter<String, Hobby> {
    @Autowired
    HobbyDao hobbyDao;

    @Override
    public Hobby convert(String strings) {
        return hobbyDao.get(Long.parseLong(strings));
    }
}