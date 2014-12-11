package codingForFun;

// Given a 2 dimensional point of a rectangle and its area, find permutations of all the other 3 points of the rectangle in 2-D space. 
// Ex:- Given X=(0,0) and A=1 
// (0,1),(1,0),(1,1) 
// (0,-1),(-1,0),(-1,-1) 
// ....
public class FindCoordinatesPermulation_other {

/*
Suppose the point is x1,y1 = (2,1) and area is 10 
Lets assume we shift the origin to the given point x1,y1 = (2,1) 

then we need to find all pairs of x,y such that product x*y = 10 
so the possible integral pair are (1,10) and (2,5) 

For each (x,y) pair there are 8 possible combinations of three other points. 
So for (2,5) we have 
1. (2,5) (2,0) (0,5) // we have assumed origin as first point 
2. (-2,5) (-2,0) (0,5) 
3. (2,-5) (2,0) (0,-5) 
4. (-2,-5) (-2,0) (0,-5) 
5. (5,2) (5,0) (0,2) 
6. (-5,2) (-5,0) (0,2) 
7. (5,-2) (5,0) (0,-2) 
8. (-5,-2) (-5,0) (0,-2) 

Now shifting origin back to given point x1,y1 = (2,1) 
by adding (x+2, y+1) to each 8 combinations above 
(this can be done in the above step itself) 

Similarly for there are 8 combinations for pair (1,10) 

So the main problem here is to find set of pairs of factor of given area and there are 8 possible combinations of three other points of the rectangle
 */
}
