from typing import *

def countingGraphs(N: int) -> int:
    return int(pow(2, N*(N-1)/2))
#Time: O(1), Space: O(1)