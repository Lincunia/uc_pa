void clear_it() {
  int c;
  while ((c = getchar()) != '\n' && c != EOF);
}

char ask_things(string txt) {
  char c_opt;
ask_it:
  cout << txt << " ('Y' para si o 'N' para no):\n";
  c_opt = getchar();
  clear_it();
  c_opt = toupper(c_opt);
  if (c_opt != 'N' && c_opt != 'Y')
  {
    cout << "Recuerde que tiene que escribir bien la opción\n\n";
    goto ask_it;
  }
  return c_opt;
}

bool check_matrix(int *it, string code, bool chk) {
  for (*it = 0; *it < 10; *it += 1) {
    if (code == productos[*it][0]) {
      chk = true;
      break;
    }
  }
  return chk;
}

void insert_aux_list(string *productos, int amount) {
  aux = {productos[1], productos[3], productos[2], productos[4], to_string(amount)};
  if(arr.empty()) {
    it = arr.insert_after(arr.before_begin(), aux);
    return;
  }
  it = arr.insert_after(it, aux);
}
