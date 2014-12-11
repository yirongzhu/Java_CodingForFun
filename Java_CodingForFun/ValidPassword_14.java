package codingForFun;

// In 1-9 keypad one key is not working. If someone enters a password then not working key will not be entered. You have given expected password and entered password.
// Check that entered password is valid or not. Ex: entered 164, expected 18684 (you need to take care as when u enter 18684 and 164 only both will be taken as 164 input)
public class ValidPassword_14 {

/*
bool IsAMatch(string actual, string expected)
{
	char faultyKey = '\0';
	int i = 0, j = 0;
	for(; i < expected.length() && j < actual.length(); ++i)
	{
		if(actual.at(j) != expected.at(i))
		{
			if('\0' != faultyKey)
			{
				if(faultyKey != expected.at(i))
					return false;
			}
			else
			{
				faultyKey = expected.at(i);
			}
		}
		else
		{
			++j;
		}
	}

	return (i == expected.length() - 1 && j == actual.length() - 1)? true : false;
}	
 */

	public boolean checkValidPassword(String actual, String expected) {
		char fault = '\0';
		int i = 0;
		int j = 0;
		for (; i < actual.length() && j < expected.length(); i++, j++) {
			if (actual.charAt(i) != expected.charAt(j)) {
				if (fault == '\0') {
					fault = expected.charAt(j);
				} else {
					if (fault != expected.charAt(i)) {
						return false;
					}
				}
				i--;
			}
		}
		while (j < expected.length() && expected.charAt(j) == fault) {
			j++;
		}
		return (i == actual.length() && j == expected.length()) ? true : false;
	}


}
