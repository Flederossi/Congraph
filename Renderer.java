package congraph;

public class Renderer {
	private int min(int[] in){
		int min = in[0];
		for (int value : in){
			if (value < min){
				min = value;
			}
		}
		return min;
	}

	private int max(int[] in){
		int max = in[0];
		for (int value : in){
			if (value > max){
				max = value;
			}
		}
		return max;
	}

	public void render(int[] res){
		for (int e = max(res); e >= min(res); e--){
			for (int i = 0; i < res.length; i++){
				if (res[i] == e){
					if (i == 0 || i == res.length - 1){
						System.out.print("-");
					}else{
						if (res[i - 1] > res[i]){
							if (res[i + 1] > res[i]){
								System.out.print("v");
							}else{
								System.out.print("\\");
							}
						}else if (res[i - 1] < res[i]){
							if (res[i + 1] < res[i]){
								System.out.print("^");
							}else{
								System.out.print("/");
							}
						}else{
							if (res[i + 1] > res[i]){
								System.out.print("/");
							}else if (res[i + 1] < res[i]){
								System.out.print("\\");
							}else{
								System.out.print("-");
							}
						}
					}
				}else{
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}
}