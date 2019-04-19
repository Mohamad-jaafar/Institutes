/*
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 * Email: mohamad.jaafar.nehme[att]gmail(.)com
 */

#include "stdlib.h"

#include "push_on_head.c"
#include "push_on_end.c"
#include "push_on_position.c"
#include "pop_from_head.c"
#include "pop_from_end.c"

//#include "copy_iter.c"
#include "length_iter.c"
#include "search_iter.c"
#include "sum_iter.c"

#include "copy_rcsv.c"
#include "length_rcsv.c"
#include "search_rcsv.c"
#include "sum_rcsv.c"

#include "print_list_iter.c"
#include "print_list_rcsv.c"
//#include "print_reverse_list_iter.c"
#include "print_reverse_list_rcsv.c"

int main (){

	struct Node* head = NULL;

	push_on_head (&head, 4);
	push_on_head (&head, 3);
	push_on_head (&head, 2);
	push_on_head (&head, 1);
	push_on_end (&head, 7);
	push_on_end (&head, 8);
	push_on_end (&head, 9);
	push_on_end (&head, 10);
	push_on_position (&head, 5, 5);
	push_on_position (&head, 6, 6);
	pop_from_head (&head);
	pop_from_head (&head);
	pop_from_end (head);
	pop_from_end (head);

	//int val = 6;
	//struct Node *cursor;
	//cursor = search_iter(head, val);
	//if (cursor != NULL) printf ("FOUND %d!!\n", val); else printf ("NOT FOUND %d!!\n", val);
	//cursor = search_rcsv(head, val);
	//if (cursor != NULL) printf ("FOUND %d!!\n", val); else printf ("NOT FOUND %d!!\n", val);

	printf ("HEAD:\n");
	print_list_iter(head);
	//print_list_rcsv(head);
	//print_reverse_list_rcsv(head, 0);
	//print_reverse_list_iter(head);
	//printf ("\n");

	printf ("NEW HEAD:\n");
	struct Node* new_head = copy_rcsv (head);
	print_list_iter(new_head);

	//printf ("%d\n", sum_iter(head));
	//printf ("%d\n", sum_rcsv(head));
	//printf ("%d\n", length_iter(head));
	//printf ("%d\n", length_rcsv(head));

	return 0;
}
