import java.util.Arrays;
import java.util.HashMap;

public class MinimumTimetoBuildBlocks {
	
//	private int split;
//	
//	public int minBuildTime(int[] blocks, int split) {
//        this.split = split;
//        Arrays.sort(blocks);
//        HashMap<Integer, Integer> cache = new HashMap<>();
//        int res = helper(blocks, blocks.length-1, 1, cache);
//        return res;
//    }
//	
//	private int helper(int[] blocks, int i, int numOfPeople, HashMap<Integer, Integer> cache) {
//		int left = i+1;
//		
//		int encode = i * 100000 + numOfPeople;
//		if(cache.containsKey(encode)) return cache.get(encode);
//		int res = 0;
//		if(numOfPeople >= left) {
//			res = Math.max(res, blocks[i]);
//		}else {
//			res = Integer.MAX_VALUE;
//			for(int j = 1; j <= Math.min(numOfPeople, (left+1)/2); j++) {
//				int worker = numOfPeople - j;
//				res = Math.min(res, split + helper(blocks, i-worker, j * 2, cache));
//				if(worker > 0)
//					res = Math.max(res, blocks[i]);
//			}
//			
//		}
//		
//		cache.put(encode, res);
//		return res;
//	}
	
	
	
	public int minBuildTime(int[] blocks, int split) {
		Arrays.sort(blocks);
		int[][] dp = new int[blocks.length][blocks.length+1];
		
		for(int i = 0; i < blocks.length; i++) {
			for(int j = blocks.length; j >= 1; j--) {
				if(j-1 >= i) {
					dp[i][j] = blocks[i];
				}else {
					dp[i][j] = Integer.MAX_VALUE;
					for(int k = 1; k <= j && i - k >= 0; k++) {
						int num = 2 * k;
						if(num > blocks.length) num = blocks.length;
						int worker = j-k;
						if(k == j) {
							dp[i][j] = Math.min(dp[i][j], split+dp[i][num]);
						} else {
							dp[i][j] = Math.min(dp[i][j], Math.max(blocks[i], split+dp[i-worker][num]));
						}
					}
				}
			}
		}
		
		
        return dp[blocks.length-1][1];
    }
	
	public static void main(String[] args) {
		MinimumTimetoBuildBlocks test = new MinimumTimetoBuildBlocks();
//		int[] blocks = {46329,14705,95646,25089,79784,51148,40515,36877,79481,79429,74852,74293,8484,15087,54393,86509,28445,77581,7776,96310,72713,93519,83583,53115,48560,30863,28557,42146,33027,41645,22630,23775,24331,65934,16512,53892,75179,29319,26106,67613,22339,91496,96822,82594,89641,90760,31982,28889,9322,50565,62429,48037,3080,48790,79867,84970,91318,62245,95691,80259,2313,17609,3002,35439,52464,17608,84795,55109,82077,36432,64629,79983,85102,30494,61882,8472,68634,69433,66476,10950,40622,9289,56288,1140,70770,92713,31148,70939,91617,61071,61610,5025,73017,1882,12800,89647,65557,32435,23535,99379,49022,50019,36251,83233,27294,4337,34918,32521,33264,38286,58671,39909,14637,76936,59338,91337,83143,57505,99743,88995,76515,71016,83191,64931,69436,28807,47174,40079,48051,78576,42577,76181,54578,84443,59390,60950,10717,59661,97737,58826,65563,5366,85865,42961,43010,45112,48033,79215,46756,37992,78047,27761,59420,46623,48653,50840,70955,75376,52322,75870,16091,13958,94465,50010,19623,82299,52461,27790,51090,29948,33540,42061,46895,49582,44889,85592,67671,10046,30932,66614,540,64338,47528,22635,76152,70518,35024,97133,68207,36215,68717,12330,64347,71505,37743,43821,80034,30733,49045,34516,53608,91997,61091,2404,89087,43363,2430,57370,90750,80250,23539,87466,65657,19181,8953,93372,12275,27162,17804,84140,35813,64871,5361,52015,11938,6224,46788,84739,66129,63139,1861,2172,19334,95823,34491,13747,94471,49414,97282,46923,7615,931,48052,74863,92393,96146,49166,2855,86010,75429,4006,5835,29929,47294,68337,28970,99963,83013,47452,23260,39268,56228,46907,95860,69367,15191,22590,45753,35419,2460,90162,13698,18437,68564,56267,20235,81139,2012,85090,63782,64115,58240,53705,89118,47045,50517,47047,45966,43469,20243,52709,20654,3110,50290,87908,31629,10801,20046,47529,45442,93598,18538,53956,46859,79072,13022,43969,79749,54193,22017,1954,76925,63801,94139,64508,11232,8840,36384,5211,60333,59718,3910,97471,19272,86201,8956,62621,86363,64186,70520,88111,91945,65860,13575,56767,66962,80580,95206,89754,94658,13444,33205,29825,77225,74523,10910,65468,38158,90086,4580,86389,31348,25321,47949,86750,10923,64594,67460,84519,4340,71209,92314,23885,3175,11313,47265,98755,50474,81046,85247,34628,51984,90408,60851,58169,31904,97627,95464,27275,9019,54819,92886,24942,16348,14063,82681,75566,70343,78725,64060,92248,84809,18088,40239,11536,95588,94226,79486,23940,70883,23959,71405,80585,89653,81743,67347,63392,97815,71310,66998,28725,62298,74545,33053,55381,70097,18847,34969,70357,47289,12769,8322,72175,82383,76897,45953,82261,12408,56975,89284,94219,48806,38065,57551,4444,51945,19509,9998,88957,15737,82028,75355,88122,7416,31564,98379,38338,34639,34025,43634,51736,64729,48098,83848,67225,68904,21869,86258,23873,85237,77967,38417,83339,16479,33141,13315,42592,13153,35079,32936,12224,56393,76165,20918,75950,50535,48519,94925,30479,21755,68262,25251,73275,33981,30224,26241,96172,29116,7981,18804,33514,51604,49607,74440,73512,12516,99123,74649,57571,21505,76200,35281,40679,61068,6352,33686,74201,35409,5282,56069,48002,59295,44995,41363,56854,52217,93786,8475,40844,54983,88247,3891,36672,22782,86207,96420,8487,56399,99253,39046,25167,28314,78338,31839,52179,64321,8762,63059,14326,4253,29393,54454,1244,66778,60064,58183,70003,3054,37679,75129,47671,14824,80819,33780,98103,10916,66793,18242,60011,72516,67859,14958,59620,50288,6055,42141,67345,79883,67031,45204,26805,68129,93176,42610,13021,1558,7739,92811,1569,78797,1587,61545,43121,58515,58986,44227,31955,70922,17475,91803,3388,78099,50972,16853,10634,25344,43372,39514,12050,1670};
//		System.out.println(test.minBuildTime(blocks, 62));
		int[] blocks = {1,2};
		System.out.println(test.minBuildTime(blocks, 5));
	}
	
}
