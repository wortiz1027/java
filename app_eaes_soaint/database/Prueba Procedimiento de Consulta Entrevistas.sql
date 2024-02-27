SET SERVEROUTPUT ON
DECLARE
  V_ARRAY_ENTREVISTAS array_Entrevista_Type;
BEGIN
  DBMS_OUTPUT.put_line('Ingreso');
  PAQUETE_CONSULTAS.CON_ENTREVISTA_CURRICULUM(1, V_ARRAY_ENTREVISTAS);
  for i in V_ARRAY_ENTREVISTAS.first .. V_ARRAY_ENTREVISTAS.last
  loop
    DBMS_OUTPUT.put_line (v_array_entrevistas(i).ID_CURRICULUM || ' ' || v_array_entrevistas(i).resultado || ' ' || v_array_entrevistas(i). OBSERVACIONES);
  end loop;
END;
