package ru.lukash.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.lukash.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setAge(rs.getInt("age"));
        person.setEmail(rs.getString("email"));
        return person;
    }
}
