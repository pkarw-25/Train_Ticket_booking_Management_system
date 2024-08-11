package dbms.railway.dao;

import dbms.railway.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.HashMap;
import java.util.Objects;

@Component
public class UserJdbcDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setUserName(rs.getString("UserName"));
        user.setFirstName(rs.getString("FirstName"));
        user.setLastName(rs.getString("LastName"));
        user.setPhoneNumber(rs.getString("PhoneNumber"));
        user.setEmail(rs.getString("Email"));
        user.setAadhaarCard(rs.getString("AadhaarCard"));
        user.setDOB(rs.getString("DOB"));
        user.setGender(rs.getString("Gender"));
        user.setUserPassword(rs.getString("UserPassword"));
        return user;
    };

    private HashMap<String, Object> getUserMap(User user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("UserName", user.getUserName());
        map.put("FirstName", user.getFirstName());
        map.put("LastName", user.getLastName());
        map.put("PhoneNumber", user.getPhoneNumber());
        map.put("Email", user.getEmail());
        map.put("AadhaarCard", user.getAadhaarCard());
        map.put("DOB", user.getDOB());
        map.put("Gender", user.getGender());
        map.put("UserPassword", user.getUserPassword());
        return map;
    }

    public void createUser(User user) {
        if (getUserByUsername(user.getUserName()) != null) {
            throw new DuplicateKeyException("Username already exists. Please choose a different username.");
        }
        String sql = "INSERT INTO User (UserName, FirstName, LastName, PhoneNumber, Email, AadhaarCard, DOB, Gender, UserPassword) VALUES (:UserName,:FirstName, :LastName, :PhoneNumber, :Email, :AadhaarCard,:DOB,:Gender, :UserPassword)";
        HashMap<String, Object> params = getUserMap(user);
        namedParameterJdbcTemplate.update(sql, params);
    }


    public List<User> getAllUsers() {
        String sql = "SELECT * FROM User";
        return namedParameterJdbcTemplate.query(sql, userRowMapper);
    }

    public User getUserByEmail(String email){
        String sql = "SELECT * FROM User WHERE Email = :Email";
        HashMap<String, Object> params = new HashMap<>();
        params.put("Email", email);
        return namedParameterJdbcTemplate.queryForObject(sql, params, userRowMapper);
    }

    public User getUserByUsername(String username){
        String sql = "SELECT * FROM User WHERE username = :UserName";
        HashMap<String, Object> params = new HashMap<>();
        params.put("UserName", username);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, userRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null when the user is not found
        }
    }
}