public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Crear usuario
        User newUser = new User("JohnDoe", "johndoe@example.com");
        userDAO.createUser(newUser);

        // Leer usuario
        User user = userDAO.getUserById(1);
        System.out.println("Usuario recuperado: " + user);

        // Actualizar usuario
        user.setUsername("JaneDoe");
        user.setEmail("janedoe@example.com");
        userDAO.updateUser(user);

        // Eliminar usuario
        userDAO.deleteUser(1);


    }
}
