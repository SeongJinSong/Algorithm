package programers.lv3;

public class l60059 {
	public static void main(String[] args) {
		int[][] key= {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}; int[][] lock= {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//		int[][] key= {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}; int[][] lock= {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		System.out.println(new l60059().solution(key, lock));
	}
	public boolean solution(int[][] key, int[][] lock) {
		int kl = key.length;
		int ll = lock.length;
		int[][] OrgBigArr = new int[2*(kl-1)+ll][2*(kl-1)+ll];
		for(int i=0;i<ll;i++) {
			for(int j=0;j<ll;j++) {
				OrgBigArr[kl-1+i][kl-1+j] = lock[i][j]; 
			}
		}
		
		int[][] tmpBigArr = new int[OrgBigArr.length][OrgBigArr.length];
		for(int r=0;r<4;r++) {
			if(r!=0)key = rotation90(key);
			for(int i=0;i<OrgBigArr.length-kl;i++) {
				for(int j=0;j<OrgBigArr.length-kl;j++) {
					initArr(tmpBigArr, OrgBigArr);
					addkey(tmpBigArr, key, i, j);
					if(checkfit(tmpBigArr, kl, ll))return true;
				}
			}
			
		}
        return false;
    }
	public void initArr(int[][] tmpBigArr, int[][] OrgBigArr) {
		for(int i=0;i<OrgBigArr.length;i++) {
			for(int j=0;j<OrgBigArr.length;j++) {
				tmpBigArr[i][j]=OrgBigArr[i][j];
			}
		}
	}
	public void addkey(int[][] arr, int[][] key, int offsetX, int offsetY) {
		for(int i=0;i<key.length;i++) {
			for(int j=0;j<key.length;j++) {
				arr[i+offsetX][j+offsetY]+=key[i][j];
			}
		}
	}
	public boolean checkfit(int[][] arr, int kl, int ll) {
		for(int i=0;i<ll;i++) {
			for(int j=0;j<ll;j++) {
				if(arr[kl-1+i][kl-1+j]!=1) {
					return false;
				}
			}
		}
		return true;
	}
	public int[][] rotation90(int[][] key) {
		int kl = key.length;
		int[][] rotationKey = new int[kl][kl];
		for(int i=0;i<kl;i++) {
			for(int j=0;j<kl;j++) {
				rotationKey[i][j]=key[j][kl-1-i];
			}
		}
		return rotationKey;
	}
}
