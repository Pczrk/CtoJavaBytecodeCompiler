float round(float a, float precision){
    return ((float)(int)(a / precision)) * precision;
}

int moduloI(int a, int b){
    return a - a/b*b;
}

float moduloF(float a, float b){
    return a - round(a/b, 1.0) * b;
}

float[] getFA(int size){
    float res[size];
    for(int i = 0; i < size; i+=1){
        res[i] = (float)i;
    }
    return res;
}

float[] moduloFA(float arr[], int size, float module){
    for(int i = 0; i < size; i+=1){
        arr[i] = moduloF(arr[i], module);
    }
    return arr;
}

void printFA(float arr[], int size){
    for(int i = 0; i < size; i+=1){
        print(arr[i]);
        print(' ');
    }
    return;
}


int main(){
    int size = 100;
    float a[0];
    a = getFA(size);
    a = moduloFA(a, size, 7.0);
    printFA(a, size);

    return 0;
}
