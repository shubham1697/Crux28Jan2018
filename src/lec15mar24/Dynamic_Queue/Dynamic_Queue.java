package lec15mar24.Dynamic_Queue;

import lec10mar4.queue.Queue;

public class Dynamic_Queue extends Queue {

	@Override
	public void enqueue(int item) throws Exception {

		if (this.size() == this.data.length) {
			int[] oq = this.data;
			int[] nq = new int[2 * oq.length];

			for (int i = 0; i < oq.length; i++) {
				int j = (this.front + i) % this.data.length;
				nq[i] = oq[j];

			}
			this.front = 0;
			this.data = nq;
		}
		super.enqueue(item);
	}

}
