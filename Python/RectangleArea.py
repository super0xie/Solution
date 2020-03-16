
class Solution:
    def computeArea(self, A: int, B: int, C: int, D: int, E: int, F: int, G: int, H: int) -> int:
        w = 0
        h = 0
        
        if A <= E:
            if E < C:
                w = min(C, G) - E
            else:
                w = 0
        else:
            if A < G:
                w = min(C, G) - A
            else:
                w = 0
        
        
        if B <= F:
            if F < D:
                h = min(D, H) - F
            else:
                h = 0
        else:
            if B < H:
                h = min(D, H) - B
            else:
                h = 0
        
        return (C-A)*(D-B) + (G-E)*(H-F) - w*h