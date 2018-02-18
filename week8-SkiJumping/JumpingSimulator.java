
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 *
 * @author Victoria (Nur) Acar
 */
public class JumpingSimulator {
    
    private List<Participant> list;
    private Random rand;
    private Map<Participant, Integer> jumpings;
    private Map<Participant, ArrayList<Integer>> votes;
    
    public JumpingSimulator() {
        list = new ArrayList<Participant>();
        rand = new Random();
        jumpings = new HashMap<Participant, Integer>();
        votes = new HashMap<Participant, ArrayList<Integer>>();
    }
    
    public void addParticipant(Participant p) {
        if(!list.contains(p)) list.add(p);
    }
    
    // prints jumping order
    public void printList() {
        Collections.sort(list);
        int count = 0;
            for(Participant p : list) {
                count++;
                System.out.printf("  %d. %s (%d points)%n", count, p.getName(), p.getPoints(p));
            }   
    }
    
    public void jump() {
        for(Participant p : list) {
            int jump =  60 + rand.nextInt(60);
            jumpings.put(p, jump);
            p.addJump(jump);
        }
    }
    
    public void vote() {
        for(Participant p : list) {
            ArrayList<Integer> v = new ArrayList<Integer>();
            for(int x=0; x<5; x++) {
                v.add(10 + rand.nextInt(11));
            }
            votes.put(p, v);
        }
    }
    
    public void Results() {
        for(Participant p : list) {
            System.out.printf("  %s%n    length: %d%n    judge votes: ", p.getName(),
                    jumpings.get(p));
            System.out.println(votes.get(p));
        }
    }
    
    public void processResults() {
        Collections.sort(list);
        Collections.reverse(list);
        for(Participant p : list) {
            System.out.printf("%d           %s%n            jump lengths: ", list.indexOf(p)+1, p);
            System.out.println(p.getLengths());
        }
    }
    
    public void setPoints() {
        for(Participant p : list) {
            int points = jumpings.get(p);
            ArrayList<Integer> voteList = votes.get(p);
            Collections.sort(voteList);
            for(int x : voteList) {
                points += x;
            }
            points = points - voteList.get(0) - voteList.get(voteList.size()-1);
            p.setPoints(p, points);
        }    
    }
}
