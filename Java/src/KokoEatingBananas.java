import java.util.PriorityQueue;

public class KokoEatingBananas {
	
	private class Pile {
		int num;
		int h;
		int bph;
	}
	
	
	public int minEatingSpeed(int[] piles, int H) {
		int hourLeft = H;
        PriorityQueue<Pile> pq = new PriorityQueue<Pile>((a, b)->{return b.bph-a.bph;}) ;
        
        long sum = 0;
        for(int pile : piles) {
        	sum += pile;
        }
        
        for(int pile : piles) {
        	Pile p = new Pile();
        	p.num = pile;
        	p.h = Math.max(1, (int)(H * ((double)pile / sum)));
        	p.bph = (int)Math.ceil((double)p.num / p.h);
        	pq.add(p);
        	hourLeft -= p.h;
        }
        
        while(hourLeft > 0) {
        	Pile max = pq.poll();
        	max.h++;
        	max.bph = (int)Math.ceil((double)max.num / max.h);
        	pq.add(max);
        	hourLeft--;
        }
        
        return pq.poll().bph;
    }
	
	public static void main(String [] args) {
		int[] piles = {332484035 ,524908576 ,855865114 ,632922376 ,222257295 ,690155293 ,112677673 ,679580077 ,337406589 ,290818316 ,877337160 ,901728858 ,679284947 ,688210097 ,692137887 ,718203285 ,629455728 ,941802184};
		KokoEatingBananas test = new KokoEatingBananas();
		System.out.println(test.minEatingSpeed(piles, 823855818));
	}

}
