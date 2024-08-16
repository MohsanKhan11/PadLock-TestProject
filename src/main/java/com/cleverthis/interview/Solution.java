package com.cleverthis.interview;

import com.cleverthis.interview.padlock.PadlockImpl;

/**
 * This is a placeholder class showing a simple boilerplate.
 * This class is not required, so you can replace with your own architecture.
 */
import java.util.ArrayList;
import java.util.List;



public class Solution {

    public void solve(PadlockImpl padlock) {
        int numpadSize = padlock.getNumpadSize();
        List<int[]> permutations = new ArrayList<>();

        generatePermutations(new int[numpadSize], 0, permutations);

        for (int[] permutation : permutations) {

            for (int i = 0; i < numpadSize; i++) {
                padlock.writeInputBuffer(i, permutation[i]);
            }
            if (padlock.isPasscodeCorrect()) {
                System.out.println("Correct passcode found: " + arrayToString(permutation));
                break;
            }
        }
    }

    private void generatePermutations(int[] current, int index, List<int[]> permutations) {
        int n = current.length;
        if (index == n) {
            permutations.add(current.clone());
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (current[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                current[index] = i;
                generatePermutations(current, index + 1, permutations);
            }
        }
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }

    }


