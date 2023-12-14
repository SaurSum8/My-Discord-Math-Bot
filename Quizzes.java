package saur.memebot;

import java.util.Random;

public class Quizzes {

	public static int[] generateQuiz(int quizType) {
		
		Random r = new Random();
		
		int[] numbers = new int[16];
		
		//numbers[2] determines the sub-type of the question
		
		switch(quizType) {
		
			case 1: {
				
				/*
				 * numbers[2] = 0, addition
				 * = 1, subtraction 
				 * = 2, multiplication
				 * = 3, division 
				*/
				
				numbers[2] = r.nextInt(4);
				
				if(numbers[2] == 3) {
					
					numbers[0] = r.nextInt(70) + 3;
					numbers[1] = r.nextInt(70) + 3;
					
					numbers[0] = numbers[0] * numbers[1];
					
				} else if(numbers[2] == 0 || numbers[2] == 1) {
					
					numbers[0] = r.nextInt(1098) + 3;
					numbers[1] = r.nextInt(1098) + 3;
					
				} else if(numbers[2] == 2) {
					
					numbers[0] = r.nextInt(158) + 3;
					numbers[1] = r.nextInt(97) + 3;
					
				}
				
				break;
			}
			
			case 2: {
				
				/*
				 * numbers[2] = 0, Arithmetic Sequences Sum
				 * = 1, linear equations (x solution)
				 * = 2, linear equations (y solution)
				 * = 3, absolute value of complex numbers
				 * = 4, smallest | zero | of a quadratic polynomial
				 * = 5, model and get value from sinusoidal (sines) function
 				*/
				
				numbers[2] = r.nextInt(6);
				
				//TODO
			//	numbers[2] = 0;
				
				if(numbers[2] == 0) {
					numbers[0] = r.nextInt(21); //First Term
					numbers[1] = r.nextInt(41) + 10; //Total Iterations
					numbers[3] = r.nextInt(31) - 15; //Difference
				
					if(numbers[3] == 0)
						numbers[3] = 1;
				
				} else if(numbers[2] == 1) {
					
					numbers[0] = r.nextInt(13) + 2; //First Equation x coefficient
					numbers[1] = r.nextInt(13) + 2; //First Equation y coefficient
					
					numbers[4] = r.nextInt(13) + 2; //Second Equation x coefficient
					numbers[5] = r.nextInt(13) + 2; //Second Equation y coefficient
					
					numbers[7] = r.nextInt(21) - 10; //x solution
					numbers[8] = r.nextInt(21) - 10; //y solution
					
					if(numbers[0] / numbers[4] == numbers[1] / numbers[5])
						numbers[4]++;
					
					numbers[3] = (numbers[0] * numbers[7]) + (numbers[1] * numbers[8]); //First Equation constant
					numbers[6] = (numbers[4] * numbers[7]) + (numbers[5] * numbers[8]); //Second Equation constant
					
				} else if(numbers[2] == 2) {
					
					numbers[0] = r.nextInt(13) + 2; //First Equation x coefficient
					numbers[1] = r.nextInt(13) + 2; //First Equation y coefficient
					
					numbers[4] = r.nextInt(13) + 2; //Second Equation x coefficient
					numbers[5] = r.nextInt(13) + 2; //Second Equation y coefficient
					
					numbers[7] = r.nextInt(21) - 10; //x solution
					numbers[8] = r.nextInt(21) - 10; //y solution
					
					if(numbers[0] / numbers[4] == numbers[1] / numbers[5])
						numbers[4]++;
					
					numbers[3] = (numbers[0] * numbers[7]) + (numbers[1] * numbers[8]); //First Equation constant
					numbers[6] = (numbers[4] * numbers[7]) + (numbers[5] * numbers[8]); //Second Equation constant
					
				} else if(numbers[2] == 3) {
					
					numbers[0] = r.nextInt(32) - 16; //Real Part
					numbers[1] = r.nextInt(32) - 16; //Coefficient of i
					
					if(numbers[0] == 0)
						numbers[0] = 1;
					
					if(numbers[1] == 0)
						numbers[1] = 2;
					
				} else if(numbers[2] == 4) {
					
					numbers[0] = r.nextInt(27) - 13; //Zero 1
					numbers[1] = r.nextInt(27) - 13; //Zero 2
					
					if(numbers[0] + numbers[1] == 0)
						numbers[0]++;
					
					if(numbers[0] == 0)
						numbers[0]++;
					
					if(numbers[1] == 0)
						numbers[1]++;
						
				} else if(numbers[2] == 5) {
					
					numbers[0] = r.nextInt(25) + 2; //Amplitude
					numbers[1] = r.nextInt(69) + 2; //Period
					numbers[3] = r.nextInt(41) - 20; //Horizontal Shift
					numbers[4] = r.nextInt(41) - 20; //Vertical Shift
					numbers[5] = r.nextInt(72); //Point To Evaluate
					
				}
				
				break;
			} 
			
			case 3: {
				
				numbers[2] = r.nextInt(4);
			//	numbers[2] = 3;
				
				/*
				 * numbers[2] = 0, Surface Area of Cylinder
				 * = 1, Volume of Cylinder
				 * = 2, Surface Area of Cube
				 * = 3, Surface Area of Cuboid
 				*/
				
				if(numbers[2] == 0) {
					
					numbers[0] = r.nextInt(20) + 1; //Height
					numbers[1] = r.nextInt(15) + 1; //Radius
					
				} else if(numbers[2] == 1) {
					
					numbers[0] = r.nextInt(20) + 1; //Height
					numbers[1] = r.nextInt(15) + 1; //Radius
					
				} else if(numbers[2] == 2) {
					
					numbers[0] = r.nextInt(20) + 1; //Side Length
					
				} else if(numbers[2] == 3) {
					
					numbers[0] = r.nextInt(15) + 1; //Length
					numbers[1] = r.nextInt(15) + 1; //Width
					numbers[3] = r.nextInt(15) + 1; //Height
					
				}
				
				break;
			}
			
			case 4: {
				
				/*
				 * numbers[2] = 0, Basic Polynomial Derivatives (Power Rule Only)
				 * = 1, 
 				*/
				
				numbers[2] = 0;
				
				if(numbers[2] == 0) {
					numbers[0] = r.nextInt(3) + 2; //Number of terms
					numbers[1] = r.nextInt(9) - 4; //Coefficient 1
					numbers[3] = r.nextInt(9) - 4; //Coefficient 2
					numbers[4] = r.nextInt(9) - 4; //Coefficient 3
					numbers[5] = r.nextInt(9) - 4; //Coefficient 4
					numbers[6] = r.nextInt(9) - 4; //Coefficient 5
					numbers[7] = r.nextInt(9) - 4; //Coefficient 6
					numbers[8] = r.nextInt(4) + 1; //Exponent 1
					numbers[9] = r.nextInt(4) + 1; //Exponent 2
					numbers[10] = r.nextInt(4) + 1; //Exponent 3
					numbers[11] = r.nextInt(4) + 1; //Exponent 4
					numbers[12] = r.nextInt(4) + 1; //Exponent 5
					numbers[13] = r.nextInt(4) + 1; //Exponent 6
					numbers[14] = r.nextInt(3) + 1; //Derivative amount (first/second/third)
					numbers[15] = r.nextInt(5) - 2; //x point to evaluate
					
					for(int i = 0; i < numbers[0]; i++) {
						
						for(int j = i + 1; j < numbers[0]; j++) {
							
							if(numbers[i + 8] == numbers[j + 8]) {
								
								if(i == 0) {
									
									numbers[1] += numbers[2 + j];
									
								} else {
									
									numbers[i + 2] += numbers[2 + j];
									
								}
								
								numbers[2 + j] = 0;
								
							}
							
						} 
						
					}
					
					if(numbers[1] == 0)
						numbers[1] = r.nextInt(3) + 2;
						
				}
				
				break;
			}
		}
		
		return numbers;
		
	}
	
	public static long getQuizAnswer(int type, int[] inputs) {
		
		Long l = null;
		
		switch(type) {
		
			case 1: {
				
				switch(inputs[2]) {
					
					case 0: {
						
						l = (long) inputs[0] + inputs[1];
						
						break;
					}
				
					case 1: {
						
						l = (long) inputs[0] - inputs[1];
						
						break;
					}
					
					case 2: {
						
						l = (long) inputs[0] * inputs[1];
						
						break;
					}
					
					case 3: {
						
						l = (long) inputs[0] / inputs[1];
						
						break;
					}
					
				}
				
				break;
			}
			
			case 2: {
				
				switch(inputs[2]) {
				
					case 0: {
						
						l = (long) inputs[1] * (2 * inputs[0] + ((inputs[1] - 1) * inputs[3])) / 2;
						
						break;
					}
					
					case 1: {
						
						//l = (long) (((inputs[5] * inputs[3]) - (inputs[1] * inputs[6])) / ((inputs[5] * inputs[0]) - (inputs[1] * inputs[4])));
						
						l = (long) inputs[7];
						
						break;
					}
					
					case 2: {
						
						l = (long) inputs[8];
						
						break;
					}
					
					case 3: {
						
						l = (long) (Math.sqrt(Math.pow(inputs[0], 2) + Math.pow(inputs[1], 2)) + 0.5);
						
						break;
					}
					
					case 4: {
						
						if(Math.abs(inputs[0]) < Math.abs(inputs[1]))
							l = (long) -(inputs[0]);
						else
							l = (long) -(inputs[1]);
						
						break;
					}
					
					case 5: {
						
						double d = inputs[0] * Math.sin((2 * Math.PI / inputs[1]) * (inputs[5] - inputs[3])) + inputs[4];
						
						if(d < 0)
							l = (long) (inputs[0] * Math.sin((2 * Math.PI / inputs[1]) * (inputs[5] - inputs[3])) + inputs[4] - 0.5);
						else
							l = (long) (inputs[0] * Math.sin((2 * Math.PI / inputs[1]) * (inputs[5] - inputs[3])) + inputs[4] + 0.5);
						
						break;
					}
				
				}
			
				break;
			}
		
			case 3: {
				
				switch(inputs[2]) {
				
				case 0: {
					
					l = (long) ((2 * Math.PI * inputs[0] * inputs[1]) + (2 * Math.PI * inputs[1] * inputs[1]) + 0.5);
					
					break;
				}
				
				case 1: {
					
					l = (long) ((Math.PI * inputs[0] * inputs[1] * inputs[1]) + 0.5);
					
					break;
				}
				
				case 2: {
					
					l = (long) (6 * inputs[0] * inputs[0]);
					
					break;
				}
				
				case 3: {
					
					l = (long) (2 * ((inputs[0] * inputs[1]) + (inputs[0] * inputs[3]) + (inputs[1] * inputs[3])));
					
					break;
				}
			
			}
				
				break;
			}
			
			case 4: {
				
				l = (long) 0;
				
				switch(inputs[2]) {
				
					case 0: {
						
						int[] newExp = new int[inputs[0]];
						int[] values = new int[inputs[0]];
						
						values[0] = inputs[1];
						newExp[0] = inputs[8];
						
						for(int i = 0; i < inputs[14]; i++) {
							
							values[0] *= newExp[0];
							newExp[0]--;
							
						}
						
						for(int i = 1; i < inputs[0]; i++) {
							
							values[i] = inputs[i + 2];
							newExp[i] = inputs[i + 8];
							
							for(int j = 0; j < inputs[14]; j++) {
								
								values[i] *= newExp[i];
								newExp[i]--;
								
							}
							
						}
						
						for(int i = 0; i < inputs[0]; i++) {
							
							values[i] *= Math.pow(inputs[15], newExp[i]);
							
							l += values[i];
						}
						
						break;
					}
				
				}
				
				break;
			}
		
		}
		
		return l;
		
	}
	
	public static String[] getQuizQuestion(int type, int[] inputs) {
		
		String[] s = new String[5];
		
		switch(type) {
		
			case 1: {
				
				switch(inputs[2]) {
					
					case 0: {
						
						s[0] = "What is " + inputs[0] + " + " + inputs[1] + "?";
						
						break;
					}
				
					case 1: {
						
						s[0] = "What is " + inputs[0] + " - " + inputs[1] + "?";
						
						break;
					}
					
					case 2: {
						
						s[0] = "What is " + inputs[0] + " x " + inputs[1] + "?";
						
						break;
					}
					
					case 3: {
						
						s[0] = "What is " + inputs[0] + " ÷ " + inputs[1] + "?";
						
						break;
					}
					
				}
				
				break;
			}
			
			case 2: {
			
				switch(inputs[2]) {
				
				case 0: {
					
					s[0] = "What does " + String.valueOf(inputs[0]);
					
					for(int i = 1; i < 4; i++) {
						
						if(inputs[0] + (i * inputs[3]) >= 0)
							s[0] = s[0] + " + " + String.valueOf(inputs[0] + (i * inputs[3]));
						else
							s[0] = s[0] + " - " + String.valueOf(-(inputs[0] + (i * inputs[3])));
					}
					
					if(inputs[0] + ((inputs[1] - 1) * inputs[3]) >= 0)
						s[0] = s[0] + " + ... + " + String.valueOf(inputs[0] + ((inputs[1] - 1) * inputs[3])) + " = ?";
					else if(inputs[0] + (4 * inputs[3]) >= 0)
						s[0] = s[0] + " + ... - " + String.valueOf(-(inputs[0] + ((inputs[1] - 1) * inputs[3]))) + " = ?";
					else
						s[0] = s[0] + " - ... - " + String.valueOf(-(inputs[0] + ((inputs[1] - 1) * inputs[3]))) + " = ?";
						
					break;
				}
				
				case 1: {
				
					s[0] = "What is the x coordinate of the solution to the linear equations:";
					
					s[1] = inputs[0] + "x + " + inputs[1] + "y = " + inputs[3];
					s[2] = inputs[4] + "x + " + inputs[5] + "y = " + inputs[6];
					
					break;
				}
				
				case 2: {
					
					s[0] = "What is the y coordinate of the solution to the linear equations:";
					
					s[1] = inputs[0] + "x + " + inputs[1] + "y = " + inputs[3];
					s[2] = inputs[4] + "x + " + inputs[5] + "y = " + inputs[6];
					
					break;
				}
				
				case 3: {
					
					if(inputs[1] > 0)
						s[0] = "Round the value of | " + inputs[0] + " + " + inputs[1] + "i | to the nearest integer";
					else
						s[0] = "Round the value of | " + inputs[0] + " - " + (-inputs[1]) + "i | to the nearest integer";
						
					break;
				}
				
				case 4: {
					
					s[0] = "Which zero is the closest to the origin, in the following quadratic equation?";
					
					//²
					
					s[1] = "x² ";
					
					if(inputs[0] + inputs[1] > 0)
						s[1] += "+ " + (inputs[0] + inputs[1]) + "x ";
					else
						s[1] += "- " + Math.abs(inputs[0] + inputs[1]) + "x ";
					
					
					if(inputs[0] * inputs[1] > 0)
						s[1] += "+ " + (inputs[0] * inputs[1]);
					else
						s[1] += "- " + Math.abs(inputs[0] * inputs[1]);
					
						
					break;
				}
				
				case 5: {
					
					s[0] = "Construct f(x), a sine function, that satisfies the given conditions and answer the value of f(" + inputs[5] + ") (Use"
							+ " a calculator, Round to the nearest integer)";
					
					s[1] = "Amplitude = " + inputs[0] + " units; Period = " + inputs[1] + " units";
					
					s[2] = "Period = " + inputs[1] + " units";
					
					
					s[3] = "Horizontal Shift = ";
					
					if(inputs[3] < 0)
						s[3] = s[3] + (-inputs[3]) + " units to the left; ";
					
					else
						s[3] = s[3] + (inputs[3]) + " units to the right; ";
					
					
					s[4] = "Vertical Shift = ";
					
					if(inputs[4] < 0)
						s[4] = s[4] + (-inputs[4]) + " units down;";
					
					else
						s[4] = s[4] + (inputs[4]) + " units up;";
					
					break;
				}
			
			}
				
				break;
			}
		
			case 3: {
				
				switch(inputs[2]) {
				
					case 0: {
						
						s[0] = "Find Surface Area of a Cylinder with: " + " (Round to nearest integer)";
						
						s[1] = "Height: " + inputs[0];
						s[2] = "Radius: " + inputs[1];
						
						break;
						
					}
					
					case 1: {
						
						s[0] = "Find Volume of a Cylinder with: " + " (Round to nearest integer)";
						
						s[1] = "Height: " + inputs[0];
						s[2] = "Radius: " + inputs[1];
						
						break;
						
					}
					
					case 2: {
						
						s[0] = "Find Surface Area of a Cube with: ";
						
						s[1] = "Side Length: " + inputs[0];
						
						break;
						
					}
					
					case 3: {
						
						s[0] = "Find Surface Area of a Cuboid with: ";
						
						s[1] = "Length: " + inputs[0];
						s[2] = "Width: " + inputs[1];
						s[3] = "Height: " + inputs[3];
						
						break;
						
					}
				
				}
				
				break;
			}
			
			case 4: {
				
				char[] superScriptNums = {' ', '²', '³', '⁴', '⁵', '⁶'};
				
				s[0] = "What is the ";
				
				switch(inputs[14]) {
				
					case 1: {
						
						s[0] += "1st ";
						
						break;
					}
					
					case 2: {
						
						s[0] += "2nd ";
						
						break;
					}
					
					case 3: {
						
						s[0] += "3rd ";
						
						break;
					}
					
					case 4: {
						
						s[0] += "4th ";
						
						break;
					}
					
					case 5: {
						
						s[0] += "5th ";
						
						break;
					}
				
				}
				
				s[0] += "derivative (with respect to x) at x = " + inputs[15] + " of:";
				
				s[1] = inputs[1] + "x" + superScriptNums[inputs[8] - 1] + " ";
				
				if(inputs[3] < 0 && inputs[3] != 0)
					s[1] += "- " + (-inputs[3]) + "x" + superScriptNums[inputs[9] - 1] + " ";
				
				else if(inputs[3] != 0)
					s[1] += "+ " + inputs[3] + "x" + superScriptNums[inputs[9] - 1] + " ";
				
				if(inputs[4] < 0 && inputs[0] >= 3 && inputs[4] != 0)
					s[1] += "- " + (-inputs[4]) + "x" + superScriptNums[inputs[10] - 1] + " ";
				
				else if(inputs[0] >= 3 && inputs[4] != 0)
					s[1] += "+ " + inputs[4] + "x" + superScriptNums[inputs[10] - 1] + " ";
				
				if(inputs[5] < 0 && inputs[0] >= 4 && inputs[5] != 0)
					s[1] += "- " + (-inputs[5]) + "x" + superScriptNums[inputs[11] - 1] + " ";
				
				else if(inputs[0] >= 4 && inputs[5] != 0)
					s[1] += "+ " + inputs[5] + "x" + superScriptNums[inputs[11] - 1] + " ";
					
				if(inputs[6] < 0 && inputs[0] >= 5 && inputs[6] != 0)
					s[1] += "- " + (-inputs[6]) + "x" + superScriptNums[inputs[12] - 1] + " ";
				
				else if(inputs[0] >= 5 && inputs[6] != 0)
					s[1] += "+ " + inputs[6] + "x" + superScriptNums[inputs[12] - 1] + " ";
				
				if(inputs[7] < 0 && inputs[0] == 6 && inputs[7] != 0)
					s[1] += "- " + (-inputs[7]) + "x" + superScriptNums[inputs[13] - 1] + " ";
				
				else if(inputs[0] == 6 && inputs[7] != 0)
					s[1] += "+ " + inputs[7] + "x" + superScriptNums[inputs[13] - 1] + " ";
				
				
				break;
			}
		
		}
		
		return s;
		
	}
	
}