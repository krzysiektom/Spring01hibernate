package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    AuthorDao authorDao;

    @Override
    public Author convert(String strings) {
        return authorDao.get(Long.parseLong(strings));
    }
}
