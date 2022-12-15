#include <iostream>
#include <vector>
#include <string>
using namespace std;


string T1[3] = {
        "       |",
        "       |",
        "       |",
};

string T2[3] = {
        "       |",
        "       |",
        "       |",
};

string T3[3] = {
        "       |",
        "       |",
        "       |",
};
vector<string> Disks;
//instructions
vector<string> DiskToBeMoved, CurrentDiskPlace, DiskMovePlace;
void init(){
    T1[0] = Disks[0];
    T1[1] = Disks[1];
    T1[2] = Disks[2];
}
void CalculateSteps(int n, string from_rod, string to_rod, string aux_rod)
{
    if (n == 1)
    {
        //cout << "Chuyen dia 1 tu cot " << from_rod <<
             //" sang cot" << to_rod<<endl;
        DiskToBeMoved.push_back(Disks[n-1]);
        CurrentDiskPlace.push_back(from_rod);
        DiskMovePlace.push_back(to_rod);
        return;
    }
        //cout << "Chuyen dia " << n << " tu cot " << from_rod <<
        // " sang cot " << to_rod << endl;
    
    CalculateSteps(n - 1, from_rod, aux_rod, to_rod);
   //cout << "Chuyen dia " << n << " tu cot " << from_rod <<
    //     "  " << to_rod << endl;
    DiskToBeMoved.push_back(Disks[n-1]);
    CurrentDiskPlace.push_back(from_rod);
    DiskMovePlace.push_back(to_rod);
    CalculateSteps(n - 1, aux_rod, to_rod, from_rod);
}
void search(int i){
    string empty = "       |";

    if(CurrentDiskPlace[i] == "T1")
    {
        for(int j = 0; j < Disks.size() ; j++){
            if(T1[j] == DiskToBeMoved[i]){
                T1[j] = empty;

            }
        }
    }
    else if(CurrentDiskPlace[i] == "T2")
    {
        for(int j = 0; j < Disks.size() ; j++){
            if(T2[j] == DiskToBeMoved[i]){
                T2[j] = empty;
            }
        }
    }
    else
    {
        for(int j = 0; j < Disks.size() ; j++){
            if(T3[j] == DiskToBeMoved[i]){
                T3[j] = empty;
            }
        }
    }

}

void notify(int i){
	if(i==0)
    	cout<<"Chuyen dia 1 tu tru 1 den tru 3"<<endl<<endl;
    else if(i == 1){
    	cout<<"Chuyen dia 3 tu tru 1 den tru 2"<<endl<<endl;
	}
	else if(i == 2){
    	cout<<"Chuyen dia 1 tu tru 3 ve tru 2"<<endl<<endl;
	}
	else if(i == 3){
    	cout<<"Chuyen dia 5 tu tru 1 den tru 3"<<endl<<endl;
	}
	else if(i == 4){
    	cout<<"Chuyen dia 1 tu tru 2 ve tru 1"<<endl<<endl;
	}
	else if(i == 5){
    	cout<<"Chuyen dia 3 tu tru 2 den tru 3"<<endl<<endl;
	}
	else if(i == 6){
    	cout<<"Chuyen dia 1 tu tru 1 den tru 3"<<endl<<endl;
	}
}

void set(int i){
    string empty = "       |";

    if(DiskMovePlace[i] == "T1")
    {
        for(int j = 0; j < Disks.size() ; j++){
            if(j == 2){
                T1[j] = DiskToBeMoved[i];
                break;
            }
            else if(T1[j] == empty && T1[j+1] != empty){
                T1[j] = DiskToBeMoved[i];
                break; 
            }
        }
    }
    else if(DiskMovePlace[i] == "T2")
    {
        for(int j = 0; j < Disks.size() ; j++){
            if(j == 2){
                T2[j] = DiskToBeMoved[i];
                break;
            }
            else if(T2[j] == empty && T2[j+1] != empty){
                T2[j] = DiskToBeMoved[i];
                break;
            }
        }
    }
    else
    {
        for(int j = 0; j < Disks.size() ; j++){
            if(j == 2){
                T3[j] = DiskToBeMoved[i];
                break;
            }
            else if(T3[j] == empty && T3[j+1] != empty){
                T3[j] = DiskToBeMoved[i];
                break;
            }
        }
    }
}
void PrintTowers(){
    for(int i = 0 ; i<3; i++){
        cout<<T1[i]<<" "<<T2[i]<<" "<<T3[i]<<endl;
    }
}
void TowerOfHanoi(){
    Disks.push_back("   *   |");
    Disks.push_back("  ***  |");
    Disks.push_back(" ***** |");
	cout<<"AN PHIM BAT KY DE BAT DAU"<<endl<<endl;
    //initialize towers
    init();
    CalculateSteps(3,"T1","T3","T2");
    PrintTowers();
    
    
    for(int i =0; i < DiskToBeMoved.size(); i++){
    	system("pause");
    	system("cls");
    	
    	
    	notify(i);
        search(i);
        set(i);
        PrintTowers();
        cout<<endl<<endl;
    }
    
    cout<<"KET THUC !"<<endl;

}

int main() {

    TowerOfHanoi();
    return 0;
}
