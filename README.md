### MediaAlpha Exercises

#### 1. Password checker:

The validity of a password is determined according to the following rules:

* Passwords must be at least 8 characters long.
* Between 8-11: requires mixed case letters, numbers and symbols
* Between 12-15: requires mixed case letters and numbers
* Between 16-19: requires mixed case letters
* 20+: any characters desired

The following `is_valid` subroutine returns 1 if a password is valid and 0 if not.

```perl

sub is_valid
{
  my $password = $_[0];
  my $password_length = length $password;
  if ($password_length < 8 ) {
    return 0;
  }
  
  my $result = 1;
  if ($password_length < 20) {
    $result = $result && has_mixed_cases($password)
  } 
  if ($password_length < 16 ) {
     $result = $result && has_number($password)
  } 
  if ($password_length < 12 ) {
    $result = $result && has_symbol($password)
  } 
  return $result;
}

sub has_mixed_cases
{
  return $_[0] =~ m[(?=.*[a-z])(?=.*[A-Z]).*];
}

sub has_number
{
  return $_[0] =~ m[(?=.*\d).*];
}

sub has_symbol
{
  return $_[0] =~ m[(?=.*[-!$%^&*()_+|~=`{}\[\]:";'<>?,.\/]).*];
}

```

#### 2. Parentheses Removal

This is a java command line application.

##### Requirements

A machine running java 1.8

##### Build steps:

1. Clone repo to your machine

```bash
git clone git@github.com:erant10/maExcercise.git
```

2. change into the project main directory, and use gradle to build the project:
```bash
$ ./gradlew build 
```

##### Execution

From the main project directory, execute using the `java` command  

```bash
$ java -jar ./build/libs/excercises-1.0.jar 
```

Enter an expression when prompt. The output will be the same expression without any redundant parentheses.

For example:
```
Please enter an expression:
> 1*(2+(3*(4+5)))
1*(2+3*(4+5))
Please enter an expression:
2 + (3 / -5)
2 + 3 / -5
Please enter an expression:
x+(y+z)+(t+(v+w))
x+y+z+t+v+w
Please enter an expression:
exit

```
Type "exit" to stop, or hit ctrl+c  