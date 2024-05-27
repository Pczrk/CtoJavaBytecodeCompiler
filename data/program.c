int kwadrat(int c){
    return c*c;
}

void fibIter(int a){
    int x = -1, y = 1;
    for(int i = -1; i < a; i+=1){
        int temp = y + x;
        x = y;
        y = temp;
        print(' ');
        print(y);
    }
    return;
}

int fibRek(int a){
    if(a < 2){
        return a;
    }
    return fibRek(a-2) + fibRek(a-1);
}

void main(){
    int a = 10;
    fibIter(a);
    print(' ');
    print(fibRek(a));

    return;
}

