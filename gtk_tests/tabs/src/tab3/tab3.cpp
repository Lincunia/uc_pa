#include "../program.h"

void third_tab(GtkWidget *notebook){
	GtkWidget *box = gtk_box_new(GTK_ORIENTATION_VERTICAL, 10);
	gtk_widget_set_margin_top(box, 10);
	gtk_widget_set_margin_bottom(box, 10);
	gtk_widget_set_margin_start(box, 10);
	gtk_widget_set_margin_end(box, 10);

	gtk_box_append(GTK_BOX(box), gtk_label_new(" * GENERIC TITLE ATTAKS *"));

	GtkWidget *tab_label = gtk_label_new("tab 3");
	gtk_notebook_append_page(GTK_NOTEBOOK(notebook), box, tab_label);
}
