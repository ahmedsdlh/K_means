public class K_means {
	static float [][]data= {{2,2},{3,4},{7,8},{9,8},{5,1},{8,7}}; static int[]K= {0,1}; static float [][]moy; static float[][]moy0; static int [][]clusters; static float [][]temp;
	static char []lettres= {'A','B','C','D','E','F'};

	static boolean compare(float [][]y,float [][]z) {
		boolean  a=true;
		for(int i=0;i<y.length;i++)for(int j=0;j<y[0].length;j++){if(y[i][j]!=z[i][j]) {a=false; break;} }
		return a;
	}
	static void remplire(float [][]y,float [][]z) {

		for(int i=0;i<y.length;i++)for(int j=0;j<y[0].length;j++){y[i][j]=z[i][j];}
		
	}
	static void aZero(float [][]d) {
		for(int i=0;i<d.length;i++)for(int j=0;j<d[0].length;j++) {
			d[i][j]=0;
		}
	}
	static void moyenne(int n) {
	
		int w=0;
		for(w=0;w<clusters[n].length&&clusters[n][w]!=-1;w++) {	
		}
		
			for(int j=0;j<data[0].length;j++) {
				for(int i=0;i<w;i++){
			moy[n][j]=moy[n][j]+((data[clusters[n][i]][j])/w);
			
		}}
		
		
	}
	static void Afficher(float [][]z) {
		int w=0;
		for(int i=0;i<z.length;i++) {
		for(w=0;w<z[0].length;w++) {
			//if(clusters[0][w]!=-1) {break;}
			 System.out.print(z[i][w]+"\t");
		}System.out.println();
		}System.out.println();
			
		
		
	}
	static void AfficherClusters() {
		int w=0;
		for(int i=0;i<clusters.length;i++) {
			System.out.print("Cluster "+i+" : ");
		for(w=0;w<clusters[0].length;w++) {
			if(clusters[i][w]!=-1)  System.out.print(lettres[clusters[i][w]]+"\t");
		}System.out.println();
		}System.out.println();
			
		
		
	}
	static void initMoy(){
		moy=new float[K.length][data[0].length];
		for(int i=0;i<moy.length;i++)for(int j=0;j<moy[0].length;j++) {
			moy[i][j]=data[K[i]][j];	
		}
		
	}
	static void rendomK(int x){
		K=new int[x];
		int i=1;
		K[0]=(int)(Math.random()*data.length);
		while(i<K.length) {
			int test=0;
			K[i]=(int)(Math.random()*data.length);
			for(int j=0;j<i;j++) {
				if(K[i]==K[j]) {test=1; break;} 
			}
			if(test==0) {i++;}
		}
	}
	static void Kmeans(int nbrK) {
		rendomK(nbrK);
		initMoy();
		Afficher(moy);
		moy0=new float[K.length][data[0].length];
		aZero(moy0);
		temp=new float[K.length][data.length];
		clusters=new int[K.length][data.length];
		
		int xw=0;
		while(compare(moy,moy0)==false) {
			remplire(moy0,moy);
		//---------------it�ration(remplire tableau)-----
		for(int i1=0;i1<temp.length;i1++) {
			for(int i2=0;i2<temp[0].length;i2++) {
				temp[i1][i2]=0;
				for(int i3=0;i3<moy[0].length;i3++) {
					temp[i1][i2]=temp[i1][i2]+Math.abs(moy[i1][i3]-data[i2][i3]); 
				}
			}
		}
		Afficher(temp);
		//--------------r�init les clusters---------------
		for(int a=0;a<clusters.length;a++) for(int b=0;b<clusters[0].length;b++) clusters[a][b]=-1;
		
		//--------------remplir les clusters---------------
		for(int i4=0;i4<temp[0].length;i4++){
			float min=1000;int index=0;int i5=0;
			for(i5=0;i5<temp.length;i5++){
				if(temp[i5][i4]<min){min=temp[i5][i4]; index=i5;}
			}
			int i6=0;
			while(clusters[index][i6]!=-1&&i6<clusters[index].length) {i6++;}
			clusters[index][i6]=i4;
		}
		//AfficherClusters();
		//---------------remplirMoyenne---------------------------------
		//Afficher(moy0);
		
		aZero(moy);
		for(int i7=0;i7<moy.length;i7++) {
			moyenne(i7);
		
		}
		AfficherClusters();
		Afficher(moy);
		} 
		
		
	}
	
	
	public static void main(String[]Args){
			Kmeans(3);
			
		}
	
	
	
	
	
}
