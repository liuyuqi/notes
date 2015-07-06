#include<stdio.h>

int get_next_available(int graph[][4], int N, int *record) {
    int row, col, flag = 0;
    for (col = 0; col < N; col++) {
        flag = 0;
        for (row = 0; row < N; row++) {
            if (graph[row][col] == 1) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            if (record[col] == 0)
                return col;
        }
    }
}

void remove_edge (int i, int graph[][4], int N) {
    int j;
    for (j = 0; j < N; j++) {
        graph[i][j] = 0;
    }
}

void output_graph(int graph[][4], int N) {
    int cnt, next_available;
    int *record = (int*)calloc(1, sizeof(int[N]));

    for (cnt = N; cnt > 0; cnt--) {
        next_available = get_next_available(graph, N, record);
        printf(" %d", next_available);
        record[next_available] = 1;
        remove_edge(next_available, graph, N);
    }
}

int main(void) {
    int graph[4][4] = {0,1,1,1,0,0,0,1,0,1,0,1,0,0,0,0};
    output_graph(graph, 4);
    return 0;
}
