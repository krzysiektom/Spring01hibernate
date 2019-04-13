package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class PublisherConverter implements Converter<String, Publisher> {

    @Autowired
    private PublisherDao publisherDao;

    @Override
    public Publisher convert(String s) {
        return publisherDao.get(Long.parseLong(s));
    }
}