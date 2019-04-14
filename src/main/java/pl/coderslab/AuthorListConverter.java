package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorListConverter implements Converter<List<String>, List<Author>> {
    @Autowired
    AuthorDao authorDao;

    @Override
    public List<Author> convert(List<String> strings) {

        return strings.stream().map(s->authorDao.get(Long.parseLong(s))).collect(Collectors.toList());
    }

}
