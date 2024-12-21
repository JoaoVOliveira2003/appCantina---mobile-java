package com.example.cantina4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox coxinha, dogao, hamburgao, paodequeijo, esfirra, cocacola, todinho, cafe, cini;
    private TextView totalDinheiro;
    private RadioButton radioButton1, radioButton2;
    private EditText editTextCini,editTextCoxinha,editTextDogao,editTextHamburgao,editTextPaoDeQueijo,
            editTextEsfirra,editTextCocaCola,editTextTodinho,editTextCafe;

    // TextWatcher para validar entrada de números no EditText
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            // Não necessário
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            // Garantir que apenas números sejam digitados
            String texto = charSequence.toString();
            if (!texto.matches("\\d*")) {
                editTextCini.setText(texto.replaceAll("[^\\d]", ""));
                editTextCini.setSelection(editTextCini.getText().length());

                editTextCoxinha.setText(texto.replaceAll("[^\\d]", ""));
                editTextCoxinha.setSelection(editTextCoxinha.getText().length());

                editTextDogao.setText(texto.replaceAll("[^\\d]", ""));
                editTextDogao.setSelection(editTextDogao.getText().length());

                editTextHamburgao.setText(texto.replaceAll("[^\\d]", ""));
                editTextHamburgao.setSelection(editTextHamburgao.getText().length());

                editTextPaoDeQueijo.setText(texto.replaceAll("[^\\d]", ""));
                editTextPaoDeQueijo.setSelection(editTextPaoDeQueijo.getText().length());

                editTextEsfirra.setText(texto.replaceAll("[^\\d]", ""));
                editTextEsfirra.setSelection(editTextEsfirra.getText().length());

                editTextCocaCola.setText(texto.replaceAll("[^\\d]", ""));
                editTextCocaCola.setSelection(editTextCocaCola.getText().length());

                editTextTodinho.setText(texto.replaceAll("[^\\d]", ""));
                editTextTodinho.setSelection(editTextTodinho.getText().length());

                editTextCafe.setText(texto.replaceAll("[^\\d]", ""));
                editTextCafe.setSelection(editTextCafe.getText().length());
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            atualizarTotal(); // Atualizar o total sempre que o texto mudar
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        configurarListeners();
    }

    private void inicializarComponentes() {
        // Inicializar CheckBoxes
        coxinha = findViewById(R.id.coxinha);
        dogao = findViewById(R.id.dogao);
        hamburgao = findViewById(R.id.hamburgao);
        paodequeijo = findViewById(R.id.paodequeijo);
        esfirra = findViewById(R.id.esfirra);
        cocacola = findViewById(R.id.cocacola);
        todinho = findViewById(R.id.todinho);
        cafe = findViewById(R.id.cafe);
        cini = findViewById(R.id.cini);

        // Inicializar TextView
        totalDinheiro = findViewById(R.id.totaldinheiro);

        // Inicializar RadioButtons
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);

        // Inicializar EditText
        editTextCini = findViewById(R.id.editTextCini);
        editTextCini.setEnabled(false); // Desabilitar por padrão

        editTextCoxinha = findViewById(R.id.editTextCoxinha);
        editTextCoxinha.setEnabled(false); // Desabilitar por padrão

        editTextDogao = findViewById(R.id.editTextDogao);
        editTextDogao.setEnabled(false); // Desabilitar por padrão

        editTextHamburgao = findViewById(R.id.editTextHamburgao);
        editTextHamburgao.setEnabled(false); // Desabilitar por padrão

        editTextPaoDeQueijo = findViewById(R.id.editTextPaoDeQueijo);
        editTextPaoDeQueijo.setEnabled(false); // Desabilitar por padrão

        editTextEsfirra = findViewById(R.id.editTextEsfirra);
        editTextEsfirra.setEnabled(false); // Desabilitar por padrão

        editTextCocaCola = findViewById(R.id.editTextCocaCola);
        editTextCocaCola.setEnabled(false); // Desabilitar por padrão

        editTextTodinho = findViewById(R.id.editTextTodinho);
        editTextTodinho.setEnabled(false); // Desabilitar por padrão

        editTextCafe = findViewById(R.id.editTextCafe);
        editTextCafe.setEnabled(false); // Desabilitar por padrão


    }

    private void configurarListeners() {

        // Listener para o CheckBox 'cini'
        cini.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextCini.setEnabled(isChecked); // Habilitar ou desabilitar o EditText
            if (isChecked) {
                editTextCini.addTextChangedListener(textWatcher);
                editTextCini.setText("1");
            } else {
                editTextCini.removeTextChangedListener(textWatcher);
                editTextCini.setText(""); // Limpar o campo
            }
            atualizarTotal();
        });

        // Listener para o CheckBox 'coxinha'
        coxinha.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextCoxinha.setEnabled(isChecked); // Habilitar ou desabilitar o EditText
            if (isChecked) {
                editTextCoxinha.addTextChangedListener(textWatcher);
                editTextCoxinha.setText("1");

            } else {
                editTextCoxinha.removeTextChangedListener(textWatcher);
                editTextCoxinha.setText(""); // Limpar o campo
            }
            atualizarTotal();
        });

        // Listener para o CheckBox 'dogao'
        dogao.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextDogao.setEnabled(isChecked); // Habilitar ou desabilitar o EditText
            if (isChecked) {
                editTextDogao.addTextChangedListener(textWatcher);
                editTextDogao.setText("1");
            } else {
                editTextDogao.removeTextChangedListener(textWatcher);
                editTextDogao.setText(""); // Limpar o campo
            }
            atualizarTotal();
        });

        // Listener para o CheckBox 'hamburgao'
        hamburgao.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextHamburgao.setEnabled(isChecked); // Habilitar ou desabilitar o EditText
            if (isChecked) {
                editTextHamburgao.addTextChangedListener(textWatcher);
                editTextHamburgao.setText("1"); // Limpar o campo

            } else {
                editTextHamburgao.removeTextChangedListener(textWatcher);
                editTextHamburgao.setText(""); // Limpar o campo
            }
            atualizarTotal();
        });

        // Listener para o CheckBox 'pão de queijo'
        paodequeijo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextPaoDeQueijo.setEnabled(isChecked); // Habilitar ou desabilitar o EditText
            if (isChecked) {
                editTextPaoDeQueijo.addTextChangedListener(textWatcher);
                editTextPaoDeQueijo.setText("1"); // Limpar o campo
            } else {
                editTextPaoDeQueijo.removeTextChangedListener(textWatcher);
                editTextPaoDeQueijo.setText(""); // Limpar o campo
            }
            atualizarTotal();
        });

        // Listener para o CheckBox 'esfirra'
        esfirra.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextEsfirra.setEnabled(isChecked); // Habilitar ou desabilitar o EditText
            if (isChecked) {
                editTextEsfirra.addTextChangedListener(textWatcher);
                editTextEsfirra.setText("1"); // Limpar o campo
            } else {
                editTextEsfirra.removeTextChangedListener(textWatcher);
                editTextEsfirra.setText(""); // Limpar o campo
            }
            atualizarTotal();
        });

        // Listener para o CheckBox 'cocacola'
        cocacola.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextCocaCola.setEnabled(isChecked); // Habilitar ou desabilitar o EditText
            if (isChecked) {
                editTextCocaCola.addTextChangedListener(textWatcher);
                editTextCocaCola.setText("1"); // Limpar o campo
            } else {
                editTextCocaCola.removeTextChangedListener(textWatcher);
                editTextCocaCola.setText(""); // Limpar o campo
            }
            atualizarTotal();
        });

        // Listener para o CheckBox 'todinho'
        todinho.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextTodinho.setEnabled(isChecked); // Habilitar ou desabilitar o EditText
            if (isChecked) {
                editTextTodinho.addTextChangedListener(textWatcher);
                editTextTodinho.setText("1"); // Limpar o campo
            } else {
                editTextTodinho.removeTextChangedListener(textWatcher);
                editTextTodinho.setText(""); // Limpar o campo
            }
            atualizarTotal();
        });

        // Listener para o CheckBox 'cafe'
        cafe.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextCafe.setEnabled(isChecked); // Habilitar ou desabilitar o EditText
            if (isChecked) {
                editTextCafe.addTextChangedListener(textWatcher);
                editTextCafe.setText("1"); // Limpar o campo
            } else {
                editTextCafe.removeTextChangedListener(textWatcher);
                editTextCafe.setText(""); // Limpar o campo
            }
            atualizarTotal();
        });

        // Listener para o RadioGroup
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> atualizarTotal());

        // Listener para os CheckBoxes
        View.OnClickListener checkBoxClickListener = view -> atualizarTotal();
        coxinha.setOnClickListener(checkBoxClickListener);
        dogao.setOnClickListener(checkBoxClickListener);
        hamburgao.setOnClickListener(checkBoxClickListener);
        paodequeijo.setOnClickListener(checkBoxClickListener);
        esfirra.setOnClickListener(checkBoxClickListener);
        cocacola.setOnClickListener(checkBoxClickListener);
        todinho.setOnClickListener(checkBoxClickListener);
        cafe.setOnClickListener(checkBoxClickListener);
    }

    private void atualizarTotal() {
        double total = 0.0;

        // Calcular valor de cocacola
        if (cocacola.isChecked()) {
            String quantidadecocacolaText = editTextCocaCola.getText().toString();
            int quantidadecocacola = quantidadecocacolaText.isEmpty() ? 0 : Integer.parseInt(quantidadecocacolaText);
            total += 2.5 * quantidadecocacola;
        }

        // Calcular valor de Cini
        if (cini.isChecked()) {
            String quantidadeCiniText = editTextCini.getText().toString();
            int quantidadeCini = quantidadeCiniText.isEmpty() ? 0 : Integer.parseInt(quantidadeCiniText);
            total += 2.0 * quantidadeCini;
        }

        // Calcular valor de Coxinha
        if (coxinha.isChecked()) {
            String quantidadeCoxinhaText = editTextCoxinha.getText().toString();
            int quantidadeCoxinha = quantidadeCoxinhaText.isEmpty() ? 0 : Integer.parseInt(quantidadeCoxinhaText);
            total += 5.0 * quantidadeCoxinha;
        }

        // Calcular valor de Dogao
        if (dogao.isChecked()) {
            String quantidadeDogaoText = editTextDogao.getText().toString();
            int quantidadeDogao = quantidadeDogaoText.isEmpty() ? 0 : Integer.parseInt(quantidadeDogaoText);
            total += 6.0 * quantidadeDogao;
        }

        // Calcular valor de Hamburgão
        if (hamburgao.isChecked()) {
            String quantidadeHamburgaoText = editTextHamburgao.getText().toString();
            int quantidadeHamburgao = quantidadeHamburgaoText.isEmpty() ? 0 : Integer.parseInt(quantidadeHamburgaoText);
            total += 7.0 * quantidadeHamburgao;
        }

        // Calcular valor de Pão de Queijo
        if (paodequeijo.isChecked()) {
            String quantidadePaoDeQueijoText = editTextPaoDeQueijo.getText().toString();
            int quantidadePaoDeQueijo = quantidadePaoDeQueijoText.isEmpty() ? 0 : Integer.parseInt(quantidadePaoDeQueijoText);
            total += 4.0 * quantidadePaoDeQueijo;
        }

        // Calcular valor de Esfirra
        if (esfirra.isChecked()) {
            String quantidadeEsfirraText = editTextEsfirra.getText().toString();
            int quantidadeEsfirra = quantidadeEsfirraText.isEmpty() ? 0 : Integer.parseInt(quantidadeEsfirraText);
            total += 3.0 * quantidadeEsfirra;
        }

        // Calcular valor de Todinho
        if (todinho.isChecked()) {
            String quantidadeTodinhoText = editTextTodinho.getText().toString();
            int quantidadeTodinho = quantidadeTodinhoText.isEmpty() ? 0 : Integer.parseInt(quantidadeTodinhoText);
            total += 2.0 * quantidadeTodinho;
        }

        // Calcular valor de Café
        if (cafe.isChecked()) {
            String quantidadeCafeText = editTextCafe.getText().toString();
            int quantidadeCafe = quantidadeCafeText.isEmpty() ? 0 : Integer.parseInt(quantidadeCafeText);
            total += 1.5 * quantidadeCafe;
        }

        // Adicionar valor adicional se o RadioButton2 estiver selecionado
        if (radioButton2.isChecked()) total += 20.0;

        // Atualizar TextView
        totalDinheiro.setText("R$ " + String.format("%.2f", total));
    }
}
