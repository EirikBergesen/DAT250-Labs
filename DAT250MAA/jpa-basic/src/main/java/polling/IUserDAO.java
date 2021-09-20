package polling;

import java.util.List;

public interface IUserDAO {
    public List<Poll> findPollsBySuperUser(int userId);
    public List<Poll> findPollsUserPartisipated(int userId);
    public void createUser();
}
