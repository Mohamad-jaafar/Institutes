/*
 * main.c
 *
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 */

#include "stdlib.h"
#include "push_first_iter.c"
#include "push_last_iter.c"
//#include "push_on_position_iter.c"
#include "pop_last_iter.c"
#include "printList.c"

int main (){

	struct Node* head = NULL;

	push_first_iter (&head, 5);
	push_first_iter (&head, 4);
	push_first_iter (&head, 3);
	push_first_iter (&head, 2);
	push_first_iter (&head, 1);
	push_last_iter (&head, 6);
	push_last_iter (&head, 9);
	push_last_iter (&head, 10);
	push_last_iter (&head, 11);
	//push_on_position_iter (&head, 7, 7);
	//push_on_position_iter (&head, 8, 8);
	pop_last_iter (head);
	printList(head);
	return 0;
}






