package polling;

import java.util.List;

public interface IPollDAO {
    public void makePoll(String name, String Answer1, String Answer2, User2 superUser);
    public void deletePoll(int pollId, User2 superUser);
    public List<Poll> findPoll(int pollId);
    public List<Poll> findPoll(String name);
}
