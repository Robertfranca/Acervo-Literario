package controller;

public class ControladorUsuario {

    private ControladorUsuario repository;

    public ControladorUsuario() throws BusinessException {
        try {
            repository = new MySQLAccessControlRepository();
        } catch (DataException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    public ControladorUsuario(ControladorUsuario repository) {
        this.repository = repository;
    }


    public void registerUser(String login, String loginConfirmation, String pass, String passConfirmation) throws BusinessException {
        if (login.isBlank()) {
            throw new BusinessException("The login is blank");
        }

        if (pass.isBlank()) {
            throw new BusinessException("The password is blank");
        }

        if (!login.equals(loginConfirmation)) {
            throw new BusinessException("The login doesn't match the confirmation");
        }

        if (!pass.equals(passConfirmation)) {
            throw new BusinessException("The password doesn't match the confirmation");
        }

        if (pass.length() < 8) {
            throw new BusinessException("The password msut have at least 8 characters");
        }

        User user = new User(login, pass);
        try {
            repository.registerUser(user);
        } catch (DataException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    public void login(String login, String senha) {
        // TODO
    }

}