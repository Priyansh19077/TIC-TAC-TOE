package com.example.tictactoe;

public class GameState {
    int arr[];

    public GameState() {
        arr = new int[9];
        for (int i = 0; i < 9; i++)
            arr[i] = 2;
    }

    public void set_value(int pos, int value) {
        arr[pos] = value;
    }

    public boolean check_if_all_filed() {
        for (int i = 0; i < 9; i++) {
            if (arr[i] == 2) {
                return false;
            }
        }
        return true;
    }

    public boolean check_if_cross_wins() {
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1)
            return true;
        else if (arr[3] == 1 && arr[4] == 1 && arr[5] == 1)
            return true;
        else if (arr[6] == 1 && arr[7] == 1 && arr[8] == 1)
            return true;
        else if (arr[0] == 1 && arr[3] == 1 && arr[6] == 1)
            return true;
        else if (arr[1] == 1 && arr[4] == 1 && arr[7] == 1)
            return true;
        else if (arr[2] == 1 && arr[5] == 1 && arr[8] == 1)
            return true;
        else if (arr[0] == 1 && arr[4] == 1 && arr[8] == 1)
            return true;
        else if (arr[6] == 1 && arr[4] == 1 && arr[2] == 1)
            return true;
        else
            return false;
    }

    public boolean check_if_zero_wins()
    {
        if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
            return true;
        else if (arr[3] == 0 && arr[4] == 0 && arr[5] == 0)
            return true;
        else if (arr[6] == 0 && arr[7] == 0 && arr[8] == 0)
            return true;
        else if (arr[0] == 0 && arr[3] == 0  && arr[6] == 0)
            return true;
        else if (arr[1] == 0 && arr[4] == 0 && arr[7] == 0)
            return true;
        else if (arr[2] == 0 && arr[5] == 0 && arr[8] == 0)
            return true;
        else if (arr[0] == 0 && arr[4] == 0 && arr[8] == 0)
            return true;
        else if (arr[6] == 0 && arr[4] == 0 && arr[2] == 0)
            return true;
        else
            return false;
    }
}
