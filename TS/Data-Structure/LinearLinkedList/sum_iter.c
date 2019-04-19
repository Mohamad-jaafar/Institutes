#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif
int sum_iter (struct Node *n) {

	int sum = 0;
	while (n != NULL) {
		sum += n -> data;
		n = n -> next;
	}
	return sum;
}
