package polling;

import java.util.List;

public interface IAnswerDao {
    public List<Answer> answersOfPoll(int PollId);
    public int answerCount(int pollId);

}
